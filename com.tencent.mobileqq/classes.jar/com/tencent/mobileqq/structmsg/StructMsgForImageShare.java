package com.tencent.mobileqq.structmsg;

import aiif;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import com.qq.taf.jce.HexUtil;
import com.tencent.image.GifDrawable;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivityConstants;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.photo.ImageInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpic.HotPicHelper;
import com.tencent.mobileqq.pic.PicUiInterface;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StructMsgForImageShare
  extends AbsShareMsg
{
  public static final int SHARE_IMAGE_FREVIEW_MAX_SZIE = 288;
  private static View.OnClickListener a = new aiif();
  public String bigUrl;
  public int mImageBizType;
  public int mIsSend = 1;
  public int mMsgType;
  public long mUniseq;
  public String rawUrl;
  public int thumbHeight;
  public String thumbUrl;
  public int thumbWidth;
  
  StructMsgForImageShare()
  {
    this.mMsgServiceID = 5;
  }
  
  StructMsgForImageShare(Bundle paramBundle)
  {
    super(paramBundle);
    if (paramBundle.getInt("req_type", 1) != 5) {
      return;
    }
    this.mMsgServiceID = 5;
    AbsStructMsgItem localAbsStructMsgItem = StructMsgElementFactory.a(0);
    localAbsStructMsgItem.b(paramBundle.getString("image_url"));
    this.mStructMsgItemLists.add(localAbsStructMsgItem);
    this.thumbWidth = paramBundle.getInt("struct_share_key_thumb_width", 0);
    this.thumbHeight = paramBundle.getInt("struct_share_key_thumb_height", 0);
  }
  
  StructMsgForImageShare(StructMsgNode paramStructMsgNode)
  {
    super(paramStructMsgNode);
  }
  
  public static boolean resendAndUploadImageShare(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, StructMsgForImageShare paramStructMsgForImageShare)
  {
    if (paramStructMsgForImageShare == null) {}
    do
    {
      return false;
      paramStructMsgForImageShare = paramStructMsgForImageShare.getFirstImageElement();
      if (paramStructMsgForImageShare != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("StructMsg", 2, "handleAppShareAction firstImageElement NULL!!!");
    return false;
    String str = paramQQAppInterface.getCurrentAccountUin();
    MessageRecord localMessageRecord = MessageRecordFactory.a(paramMessageRecord);
    paramQQAppInterface.a().a(localMessageRecord, str);
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.jdField_b_of_type_JavaLangString = str;
    localTransferRequest.c = paramMessageRecord.frienduin;
    localTransferRequest.jdField_a_of_type_Int = paramMessageRecord.istroop;
    localTransferRequest.jdField_b_of_type_Int = 1;
    localTransferRequest.jdField_a_of_type_Long = localMessageRecord.uniseq;
    localTransferRequest.jdField_a_of_type_Boolean = true;
    localTransferRequest.e = 1030;
    localTransferRequest.i = paramStructMsgForImageShare.u;
    HotPicHelper.a(localMessageRecord, localTransferRequest);
    paramQQAppInterface.a().a(localTransferRequest);
    return true;
  }
  
  public static final String scaleLocalImage(Context paramContext, ImageInfo paramImageInfo, String paramString, int paramInt)
  {
    if ((paramContext == null) || (paramImageInfo == null) || (paramString == null)) {
      paramImageInfo = null;
    }
    String str1;
    long l1;
    do
    {
      return paramImageInfo;
      File localFile = new File(paramString);
      if (!localFile.exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("StructMsg", 2, "handleAppShareAction mShareImageUrl NULL!!!");
        }
        return null;
      }
      String str2 = null;
      str1 = str2;
      for (;;)
      {
        try
        {
          if (!GifDrawable.isGifFile(localFile)) {
            continue;
          }
          str1 = str2;
          l1 = localFile.length();
          if (l1 >= 12582912L) {
            continue;
          }
          paramContext = paramString;
        }
        catch (Exception paramImageInfo)
        {
          boolean bool;
          paramContext = str1;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("StructMsg", 2, paramImageInfo.getMessage());
          paramContext = str1;
          continue;
          paramImageInfo = paramContext;
        }
        if (!TextUtils.isEmpty(paramContext)) {
          continue;
        }
        return null;
        str1 = str2;
        localFile = new File(AbsStructMsg.D);
        str1 = str2;
        if (!localFile.exists())
        {
          str1 = str2;
          localFile.mkdirs();
        }
        str1 = str2;
        str2 = AbsStructMsg.D + System.currentTimeMillis() + ".jpg";
        str1 = str2;
        bool = com.tencent.mobileqq.utils.ImageUtil.a(4, paramContext, paramString, str2, true, paramImageInfo, paramInt);
        paramContext = str2;
        if (!bool) {
          paramContext = paramString;
        }
      }
    } while (!QLog.isColorLevel());
    try
    {
      paramImageInfo = new BitmapFactory.Options();
      paramImageInfo.inJustDecodeBounds = true;
      SafeBitmapFactory.decodeFile(paramString, paramImageInfo);
      paramInt = paramImageInfo.outWidth;
      int i = paramImageInfo.outHeight;
      SafeBitmapFactory.decodeFile(paramContext, paramImageInfo);
      int j = paramImageInfo.outWidth;
      int k = paramImageInfo.outHeight;
      l1 = new File(paramString).length();
      long l2 = new File(paramContext).length();
      QLog.d("StructMsg", 2, "srcBmp = " + paramString + ", length = " + l1 + ", srcWidth = " + paramInt + ", srcHeight = " + i + ", destBmp = " + paramContext + ", length = " + l2 + ", destWidth = " + j + ", distHeight = " + k);
      return paramContext;
    }
    catch (Exception paramImageInfo)
    {
      QLog.d("StructMsg", 2, paramImageInfo.getMessage());
    }
    return paramContext;
  }
  
  public static boolean sendAndUploadImageShare(QQAppInterface paramQQAppInterface, StructMsgForImageShare paramStructMsgForImageShare, String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    if (paramStructMsgForImageShare == null) {
      return false;
    }
    if ((paramString1 == null) || (paramInt1 < 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, "handleAppShareAction toUin is NULL!!!");
      }
      return false;
    }
    StructMsgItemImage localStructMsgItemImage = paramStructMsgForImageShare.getFirstImageElement();
    if (localStructMsgItemImage == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, "handleAppShareAction firstImageElement NULL!!!");
      }
      return false;
    }
    int i = MobileQQService.jdField_a_of_type_Int;
    MobileQQService.jdField_a_of_type_Int = i + 1;
    long l = i;
    String str = paramQQAppInterface.getCurrentAccountUin();
    if (((paramInt1 != 1000) && (paramInt1 != 1020) && (paramInt1 != 1004)) || (TextUtils.isEmpty(paramString2))) {
      paramString2 = str;
    }
    for (;;)
    {
      localStructMsgItemImage.d = 0L;
      paramString2 = MessageRecordFactory.a(paramQQAppInterface, str, paramString1, paramString2, paramInt1, l, paramStructMsgForImageShare);
      if (MsgProxyUtils.a(paramInt1) == 1032) {
        ConfessMsgUtil.a(paramQQAppInterface, paramString2, paramString1, paramInt1, paramInt2);
      }
      paramQQAppInterface.a().a(paramString2, str);
      if (!paramStructMsgForImageShare.checkImageSharePic(paramQQAppInterface.getApp())) {
        return false;
      }
      if (FileUtils.c(localStructMsgItemImage.u))
      {
        paramStructMsgForImageShare = HexUtil.bytes2HexStr(MD5.getFileMd5(localStructMsgItemImage.u));
        if (paramStructMsgForImageShare == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, "handleAppShareAction MD5 NULL!!!");
          }
          return false;
        }
        paramStructMsgForImageShare = URLDrawableHelper.a(paramStructMsgForImageShare, 1);
        if (paramStructMsgForImageShare != null) {
          break label327;
        }
      }
      label327:
      for (paramStructMsgForImageShare = null;; paramStructMsgForImageShare = paramStructMsgForImageShare.toString())
      {
        if (!AbsDownloader.a(paramStructMsgForImageShare))
        {
          paramStructMsgForImageShare = AbsDownloader.d(paramStructMsgForImageShare);
          FileUtils.d(localStructMsgItemImage.u, paramStructMsgForImageShare);
        }
        paramStructMsgForImageShare = new TransferRequest();
        paramStructMsgForImageShare.jdField_b_of_type_JavaLangString = str;
        paramStructMsgForImageShare.c = paramString1;
        paramStructMsgForImageShare.jdField_a_of_type_Int = paramInt1;
        paramStructMsgForImageShare.jdField_b_of_type_Int = 1;
        paramStructMsgForImageShare.jdField_a_of_type_Long = paramString2.uniseq;
        paramStructMsgForImageShare.jdField_a_of_type_Boolean = true;
        paramStructMsgForImageShare.e = 1030;
        paramStructMsgForImageShare.i = localStructMsgItemImage.u;
        paramQQAppInterface.a().a(paramStructMsgForImageShare);
        return true;
      }
    }
  }
  
  public static boolean sendAndUploadImageShareHotPic(QQAppInterface paramQQAppInterface, StructMsgForImageShare paramStructMsgForImageShare, String paramString1, int paramInt1, String paramString2, String paramString3, long paramLong, String paramString4, int paramInt2)
  {
    if (paramStructMsgForImageShare == null) {
      return false;
    }
    if ((paramString1 == null) || (paramInt1 < 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, "handleAppShareAction toUin is NULL!!!");
      }
      return false;
    }
    StructMsgItemImage localStructMsgItemImage = paramStructMsgForImageShare.getFirstImageElement();
    if (localStructMsgItemImage == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, "handleAppShareAction firstImageElement NULL!!!");
      }
      return false;
    }
    int i = MobileQQService.jdField_a_of_type_Int;
    MobileQQService.jdField_a_of_type_Int = i + 1;
    long l = i;
    String str = paramQQAppInterface.getCurrentAccountUin();
    if (((paramInt1 != 1000) && (paramInt1 != 1020) && (paramInt1 != 1004)) || (TextUtils.isEmpty(paramString2))) {
      paramString2 = str;
    }
    for (;;)
    {
      localStructMsgItemImage.d = 0L;
      paramString2 = MessageRecordFactory.a(paramQQAppInterface, str, paramString1, paramString2, paramInt1, l, paramStructMsgForImageShare);
      HotPicHelper.a(paramString2, paramString3, paramLong, paramString4);
      if (MsgProxyUtils.a(paramInt1) == 1032) {
        ConfessMsgUtil.a(paramQQAppInterface, paramString2, paramString1, paramInt1, paramInt2);
      }
      paramQQAppInterface.a().a(paramString2, str);
      if (FileUtils.c(localStructMsgItemImage.u))
      {
        paramStructMsgForImageShare = HexUtil.bytes2HexStr(MD5.getFileMd5(localStructMsgItemImage.u));
        if (paramStructMsgForImageShare == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, "handleAppShareAction MD5 NULL!!!");
          }
          return false;
        }
        paramStructMsgForImageShare = URLDrawableHelper.a(paramStructMsgForImageShare, 1);
        if (paramStructMsgForImageShare != null) {
          break label331;
        }
      }
      label331:
      for (paramStructMsgForImageShare = null;; paramStructMsgForImageShare = paramStructMsgForImageShare.toString())
      {
        if (!AbsDownloader.a(paramStructMsgForImageShare))
        {
          paramStructMsgForImageShare = AbsDownloader.d(paramStructMsgForImageShare);
          FileUtils.d(localStructMsgItemImage.u, paramStructMsgForImageShare);
        }
        paramStructMsgForImageShare = new TransferRequest();
        paramStructMsgForImageShare.jdField_b_of_type_JavaLangString = str;
        paramStructMsgForImageShare.c = paramString1;
        paramStructMsgForImageShare.jdField_a_of_type_Int = paramInt1;
        paramStructMsgForImageShare.jdField_b_of_type_Int = 1;
        paramStructMsgForImageShare.jdField_a_of_type_Long = paramString2.uniseq;
        paramStructMsgForImageShare.jdField_a_of_type_Boolean = true;
        paramStructMsgForImageShare.e = 1030;
        paramStructMsgForImageShare.i = localStructMsgItemImage.u;
        HotPicHelper.a(paramString2, paramStructMsgForImageShare);
        paramQQAppInterface.a().a(paramStructMsgForImageShare);
        return true;
      }
    }
  }
  
  public boolean checkImageSharePic(Context paramContext)
  {
    StructMsgItemImage localStructMsgItemImage = getFirstImageElement();
    if (localStructMsgItemImage != null)
    {
      if (localStructMsgItemImage.a == null) {
        localStructMsgItemImage.a = this;
      }
      Object localObject2 = localStructMsgItemImage.a();
      URLDrawable localURLDrawable = ForwardUtils.a(paramContext, (MessageForPic)localObject2);
      if (new File(((MessageForPic)localObject2).path).exists())
      {
        localStructMsgItemImage.u = ((MessageForPic)localObject2).path;
        if (TextUtils.isEmpty(localStructMsgItemImage.u))
        {
          if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, "StructingMsgItemBuilder onMenuItemClicked forward imageElement.mShareImageUrl is null!!!");
          }
          return false;
        }
      }
      else
      {
        Object localObject1 = null;
        paramContext = localURLDrawable.getURL().toString();
        if (AbsDownloader.a(paramContext))
        {
          localObject2 = AbsDownloader.a(paramContext);
          paramContext = localObject1;
          if (localObject2 != null)
          {
            paramContext = localObject1;
            if (((File)localObject2).exists()) {
              paramContext = ((File)localObject2).getAbsolutePath();
            }
          }
        }
        for (;;)
        {
          localStructMsgItemImage.u = paramContext;
          break;
          localObject2 = AbsDownloader.a(URLDrawableHelper.a((PicUiInterface)localObject2, 65537).toString());
          paramContext = localObject1;
          if (localObject2 != null)
          {
            paramContext = localObject1;
            if (((File)localObject2).exists()) {
              paramContext = ((File)localObject2).getAbsolutePath();
            }
          }
        }
      }
      if (!AbsDownloader.a(localURLDrawable.getURL().toString())) {
        localURLDrawable.startDownload();
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StructMsg", 2, "StructingMsgItemBuilder onMenuItemClicked forward imageElement is null!!!");
    }
    return false;
  }
  
  public StructMsgItemImage getFirstImageElement()
  {
    if (this.mStructMsgItemLists != null)
    {
      int i = 0;
      while (i < this.mStructMsgItemLists.size())
      {
        Object localObject = (AbsStructMsgElement)this.mStructMsgItemLists.get(i);
        if ((localObject instanceof AbsStructMsgItem))
        {
          localObject = (AbsStructMsgItem)localObject;
          if (((AbsStructMsgItem)localObject).a != null)
          {
            int j = 0;
            while (j < ((AbsStructMsgItem)localObject).a.size())
            {
              AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)((AbsStructMsgItem)localObject).a.get(j);
              if ((localAbsStructMsgElement != null) && ((localAbsStructMsgElement instanceof StructMsgItemImage))) {
                return (StructMsgItemImage)localAbsStructMsgElement;
              }
              j += 1;
            }
          }
        }
        i += 1;
      }
    }
    return null;
  }
  
  public View.OnClickListener getOnClickListener()
  {
    return a;
  }
  
  public View getPreDialogView(Context paramContext, View paramView)
  {
    Object localObject1 = paramContext.getResources();
    int i = (int)((Resources)localObject1).getDisplayMetrics().density;
    paramView = new ImageView(paramContext);
    paramView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    paramView.setMaxHeight(i * 288);
    paramView.setAdjustViewBounds(true);
    paramView.setPadding(0, 10, 0, 10);
    Object localObject2 = new LinearLayout.LayoutParams(-1, -2);
    ((LinearLayout.LayoutParams)localObject2).gravity = 17;
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    paramView.setMinimumHeight(i * 120);
    if (ChatActivityConstants.N) {
      paramView.setContentDescription(paramContext.getString(2131432758));
    }
    paramContext = ((Resources)localObject1).getDrawable(2130846093);
    localObject1 = getFirstImageElement();
    if ((localObject1 != null) && (((StructMsgItemImage)localObject1).u != null))
    {
      localObject2 = ((StructMsgItemImage)localObject1).u;
      if ((!((String)localObject2).startsWith("http://")) && (!((String)localObject2).startsWith("https://")))
      {
        localObject2 = com.tencent.biz.common.util.ImageUtil.a(((StructMsgItemImage)localObject1).u, i * 288);
        if (localObject2 != null)
        {
          paramView.setImageBitmap(com.tencent.mobileqq.utils.ImageUtil.a((Bitmap)localObject2, new File(((StructMsgItemImage)localObject1).u)));
          return paramView;
        }
        paramView.setImageDrawable(paramContext);
        return paramView;
      }
      paramView.setImageDrawable(URLDrawable.getDrawable((String)localObject2, paramContext, paramContext));
      return paramView;
    }
    paramView.setImageDrawable(paramContext);
    return paramView;
  }
  
  public View getView(Context paramContext, View paramView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, Bundle paramBundle)
  {
    if (this.mMsgException)
    {
      paramContext = getVersionExceptionView(paramContext, paramView, paramOnLongClickAndTouchListener, paramBundle);
      paramContext.setId(2131361855);
      paramContext.setTag(2131361855, this);
      return paramContext;
    }
    paramOnLongClickAndTouchListener = (ViewGroup)super.getView(paramContext, paramView, paramOnLongClickAndTouchListener, paramBundle);
    StructMsgItemImage localStructMsgItemImage = getFirstImageElement();
    if (localStructMsgItemImage != null)
    {
      localStructMsgItemImage.a = this;
      paramOnLongClickAndTouchListener.addView(localStructMsgItemImage.a(paramContext, paramView, paramBundle));
    }
    paramContext = paramOnLongClickAndTouchListener.getLayoutParams();
    if (paramContext == null) {
      paramContext = new LinearLayout.LayoutParams(-2, -2);
    }
    for (;;)
    {
      paramOnLongClickAndTouchListener.setLayoutParams(paramContext);
      paramOnLongClickAndTouchListener.setBackgroundDrawable(null);
      paramOnLongClickAndTouchListener.setId(2131361855);
      paramOnLongClickAndTouchListener.setTag(2131361855, this);
      return paramOnLongClickAndTouchListener;
      paramContext.height = -2;
      paramContext.width = -2;
    }
  }
  
  protected boolean parseContentNode(StructMsgNode paramStructMsgNode)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramStructMsgNode == null)
    {
      bool1 = true;
      return bool1;
    }
    if ("item".equals(paramStructMsgNode.jdField_b_of_type_JavaLangString)) {}
    for (Object localObject = paramStructMsgNode.a("layout");; localObject = StructMsgElementFactory.a(paramStructMsgNode.jdField_b_of_type_JavaLangString))
    {
      try
      {
        if (!TextUtils.isEmpty((CharSequence)localObject)) {}
        for (int i = Integer.parseInt((String)localObject);; i = 0)
        {
          localObject = StructMsgElementFactory.a(i);
          bool1 = bool2;
          if (localObject == null) {
            break;
          }
          bool1 = bool2;
          if (!((AbsStructMsgElement)localObject).a(paramStructMsgNode)) {
            break;
          }
          addItem((AbsStructMsgElement)localObject);
          return true;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (NumberFormatException paramStructMsgNode)
      {
        bool1 = bool2;
      }
      QLog.d("StructMsg", 2, "Item layout value is " + 0);
      return false;
    }
  }
  
  public void readExternal(ObjectInput paramObjectInput)
  {
    int m = 0;
    for (;;)
    {
      int n;
      Object localObject;
      int k;
      int j;
      try
      {
        n = paramObjectInput.readInt();
        this.mVersion = n;
        if (n == 1)
        {
          this.mMsgTemplateID = paramObjectInput.readInt();
          this.mMsgAction = paramObjectInput.readUTF();
          this.mMsgActionData = paramObjectInput.readUTF();
          this.mMsg_A_ActionData = paramObjectInput.readUTF();
          this.mMsg_I_ActionData = paramObjectInput.readUTF();
          this.mMsgUrl = paramObjectInput.readUTF();
          this.mMsgBrief = paramObjectInput.readUTF();
          this.mContentLayout = paramObjectInput.readInt();
          this.mContentCover = paramObjectInput.readUTF();
          this.mContentTitle = paramObjectInput.readUTF();
          this.mContentSummary = paramObjectInput.readUTF();
          localObject = StructMsgElementFactory.a(this.mContentLayout);
          ((AbsStructMsgItem)localObject).a(new StructMsgItemCover(this.mContentCover));
          ((AbsStructMsgItem)localObject).a(new StructMsgItemTitle(this.mContentTitle));
          ((AbsStructMsgItem)localObject).a(new StructMsgItemSummary(this.mContentSummary));
          addItem((AbsStructMsgElement)localObject);
          this.mSourceAppid = paramObjectInput.readLong();
          this.mSourceIcon = paramObjectInput.readUTF();
          this.mSourceName = paramObjectInput.readUTF();
          this.mSourceUrl = paramObjectInput.readUTF();
          this.mSourceAction = paramObjectInput.readUTF();
          this.mSourceActionData = paramObjectInput.readUTF();
          this.mSource_A_ActionData = paramObjectInput.readUTF();
          this.mSource_I_ActionData = paramObjectInput.readUTF();
          this.fwFlag = paramObjectInput.readInt();
          if ((TextUtils.isEmpty(this.mSourceName)) && (TextUtils.isEmpty(this.mSourceIcon))) {
            break label972;
          }
          this.mHasSource = true;
          return;
        }
        if (n < 2) {
          break label967;
        }
        this.mMsgTemplateID = paramObjectInput.readInt();
        this.mMsgAction = paramObjectInput.readUTF();
        this.mMsgActionData = paramObjectInput.readUTF();
        this.mMsg_A_ActionData = paramObjectInput.readUTF();
        this.mMsg_I_ActionData = paramObjectInput.readUTF();
        this.mMsgUrl = paramObjectInput.readUTF();
        this.mMsgBrief = paramObjectInput.readUTF();
        int i1 = paramObjectInput.readInt();
        k = 0;
        i = 1;
        if (k < i1)
        {
          localObject = paramObjectInput.readUTF();
          if ("item".equals(localObject))
          {
            localObject = StructMsgElementFactory.a(paramObjectInput.readInt());
            j = i;
            if (localObject == null) {
              break label973;
            }
            ((AbsStructMsgElement)localObject).a(paramObjectInput);
            j = i;
            if (!TextUtils.isEmpty(((AbsStructMsgElement)localObject).c))
            {
              ((AbsStructMsgElement)localObject).s = String.valueOf(i);
              j = i + 1;
            }
            ((AbsStructMsgElement)localObject).t = this.uin;
            addItem((AbsStructMsgElement)localObject);
            break label973;
          }
          AbsStructMsgElement localAbsStructMsgElement = StructMsgElementFactory.a((String)localObject);
          localObject = localAbsStructMsgElement;
          if (localAbsStructMsgElement == null) {
            continue;
          }
          localObject = localAbsStructMsgElement;
          if (!AbsStructMsgItem.class.isInstance(localAbsStructMsgElement)) {
            continue;
          }
          paramObjectInput.readInt();
          localObject = localAbsStructMsgElement;
          continue;
        }
        this.mSourceAppid = paramObjectInput.readLong();
      }
      catch (IOException paramObjectInput)
      {
        if ((paramObjectInput.getMessage() != null) && (paramObjectInput.getMessage().equals("structmsg_version_error"))) {
          this.mMsgException = true;
        }
        paramObjectInput.printStackTrace();
        return;
      }
      this.mSourceIcon = paramObjectInput.readUTF();
      this.mSourceName = paramObjectInput.readUTF();
      this.mSourceUrl = paramObjectInput.readUTF();
      this.mSourceAction = paramObjectInput.readUTF();
      this.mSourceActionData = paramObjectInput.readUTF();
      this.mSource_A_ActionData = paramObjectInput.readUTF();
      this.mSource_I_ActionData = paramObjectInput.readUTF();
      this.fwFlag = paramObjectInput.readInt();
      this.mFlag = paramObjectInput.readInt();
      this.mHasSource = paramObjectInput.readBoolean();
      this.mCommentText = paramObjectInput.readUTF();
      if (n >= 3)
      {
        this.mCompatibleText = paramObjectInput.readUTF();
        this.msgId = paramObjectInput.readLong();
        this.mPromotionType = paramObjectInput.readInt();
        this.mPromotionMsg = paramObjectInput.readUTF();
        this.mPromotionMenus = paramObjectInput.readUTF();
        this.mPromotionMenuDestructiveIndex = paramObjectInput.readInt();
        i = m;
        while (i < this.mStructMsgItemLists.size())
        {
          localObject = (AbsStructMsgElement)this.mStructMsgItemLists.get(i);
          ((AbsStructMsgElement)localObject).jdField_a_of_type_Long = this.msgId;
          ((AbsStructMsgElement)localObject).d = this.mPromotionType;
          i += 1;
        }
        if (n >= 5)
        {
          this.source_puin = paramObjectInput.readUTF();
          if (n >= 7)
          {
            this.adverSign = paramObjectInput.readInt();
            this.adverKey = paramObjectInput.readUTF();
            this.index = paramObjectInput.readUTF();
            this.index_name = paramObjectInput.readUTF();
            this.index_type = paramObjectInput.readUTF();
            if (n >= 16)
            {
              this.thumbWidth = paramObjectInput.readInt();
              this.thumbHeight = paramObjectInput.readInt();
              this.mImageBizType = paramObjectInput.readInt();
              if (n >= 20)
              {
                this.rawUrl = paramObjectInput.readUTF();
                if (n >= 21)
                {
                  this.bigUrl = paramObjectInput.readUTF();
                  this.thumbUrl = paramObjectInput.readUTF();
                  return;
                  label967:
                  this.mMsgException = true;
                }
              }
            }
          }
        }
      }
      label972:
      return;
      label973:
      k += 1;
      int i = j;
    }
  }
  
  protected void toContentXml(AbsStructMsg.XmlSerializerWithFilter paramXmlSerializerWithFilter)
  {
    Iterator localIterator = iterator();
    while (localIterator.hasNext()) {
      ((AbsStructMsgElement)localIterator.next()).a(paramXmlSerializerWithFilter);
    }
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeInt(this.mMsgServiceID);
    paramObjectOutput.writeInt(this.mVersion);
    paramObjectOutput.writeInt(this.mMsgTemplateID);
    if (this.mMsgAction == null)
    {
      localObject = "";
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mMsgActionData != null) {
        break label186;
      }
      localObject = "";
      label59:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mMsg_A_ActionData != null) {
        break label194;
      }
      localObject = "";
      label77:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mMsg_I_ActionData != null) {
        break label202;
      }
      localObject = "";
      label95:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mMsgUrl != null) {
        break label210;
      }
      localObject = "";
      label113:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mMsgBrief != null) {
        break label218;
      }
    }
    label186:
    label194:
    label202:
    label210:
    label218:
    for (Object localObject = "";; localObject = this.mMsgBrief)
    {
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(getItemCount());
      localObject = iterator();
      while (((Iterator)localObject).hasNext()) {
        ((AbsStructMsgElement)((Iterator)localObject).next()).a(paramObjectOutput);
      }
      localObject = this.mMsgAction;
      break;
      localObject = this.mMsgActionData;
      break label59;
      localObject = this.mMsg_A_ActionData;
      break label77;
      localObject = this.mMsg_I_ActionData;
      break label95;
      localObject = this.mMsgUrl;
      break label113;
    }
    paramObjectOutput.writeLong(this.mSourceAppid);
    if (this.mSourceIcon == null)
    {
      localObject = "";
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSourceName != null) {
        break label687;
      }
      localObject = "";
      label265:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSourceUrl != null) {
        break label695;
      }
      localObject = "";
      label283:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSourceAction != null) {
        break label703;
      }
      localObject = "";
      label301:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSourceActionData != null) {
        break label711;
      }
      localObject = "";
      label319:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSource_A_ActionData != null) {
        break label719;
      }
      localObject = "";
      label337:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSource_I_ActionData != null) {
        break label727;
      }
      localObject = "";
      label355:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.fwFlag);
      paramObjectOutput.writeInt(this.mFlag);
      paramObjectOutput.writeBoolean(this.mHasSource);
      if (this.mCommentText != null) {
        break label735;
      }
      localObject = "";
      label403:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mCompatibleText != null) {
        break label743;
      }
      localObject = "";
      label421:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeLong(this.msgId);
      paramObjectOutput.writeInt(this.mPromotionType);
      if (this.mPromotionMsg != null) {
        break label751;
      }
      localObject = "";
      label459:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mPromotionMenus != null) {
        break label759;
      }
      localObject = "";
      label477:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.mPromotionMenuDestructiveIndex);
      if (this.source_puin != null) {
        break label767;
      }
      localObject = "";
      label505:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.adverSign);
      if (this.adverKey != null) {
        break label775;
      }
      localObject = "";
      label533:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.index != null) {
        break label783;
      }
      localObject = "";
      label551:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.index_name != null) {
        break label791;
      }
      localObject = "";
      label569:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.index_type != null) {
        break label799;
      }
      localObject = "";
      label587:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.thumbWidth);
      paramObjectOutput.writeInt(this.thumbHeight);
      paramObjectOutput.writeInt(this.mImageBizType);
      if (this.rawUrl != null) {
        break label807;
      }
      localObject = "";
      label635:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.bigUrl != null) {
        break label815;
      }
      localObject = "";
      label653:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.thumbUrl != null) {
        break label823;
      }
    }
    label687:
    label823:
    for (localObject = "";; localObject = this.thumbUrl)
    {
      paramObjectOutput.writeUTF((String)localObject);
      return;
      localObject = this.mSourceIcon;
      break;
      localObject = this.mSourceName;
      break label265;
      label695:
      localObject = this.mSourceUrl;
      break label283;
      label703:
      localObject = this.mSourceAction;
      break label301;
      label711:
      localObject = this.mSourceActionData;
      break label319;
      label719:
      localObject = this.mSource_A_ActionData;
      break label337;
      label727:
      localObject = this.mSource_I_ActionData;
      break label355;
      label735:
      localObject = this.mCommentText;
      break label403;
      label743:
      localObject = this.mCompatibleText;
      break label421;
      label751:
      localObject = this.mPromotionMsg;
      break label459;
      label759:
      localObject = this.mPromotionMenus;
      break label477;
      label767:
      localObject = this.source_puin;
      break label505;
      localObject = this.adverKey;
      break label533;
      localObject = this.index;
      break label551;
      localObject = this.index_name;
      break label569;
      localObject = this.index_type;
      break label587;
      localObject = this.rawUrl;
      break label635;
      localObject = this.bigUrl;
      break label653;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForImageShare
 * JD-Core Version:    0.7.0.1
 */