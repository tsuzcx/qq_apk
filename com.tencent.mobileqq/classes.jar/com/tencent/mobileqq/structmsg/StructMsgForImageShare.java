package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
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
import android.widget.TextView;
import com.qq.taf.jce.HexUtil;
import com.tencent.image.GifDrawable;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.ChatActivityConstants;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.forward.ForwardOrderManager;
import com.tencent.mobileqq.activity.photo.ImageInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.PicUiInterface;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.open.sdk.report.SdkShareReporter;
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
  public static final String BRIEF_PREFIX = "[分享]";
  public static final int SHARE_IMAGE_FREVIEW_MAX_SZIE = 140;
  private static View.OnClickListener a = new StructMsgForImageShare.1();
  public String bigUrl;
  public int height;
  public int mImageBizType = 0;
  public int mIsSend = 1;
  public int mMsgType = 0;
  public long mUniseq = 0L;
  public String rawUrl;
  public int thumbHeight;
  public String thumbUrl;
  public int thumbWidth;
  public int width;
  
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
    if (paramStructMsgForImageShare == null) {
      return false;
    }
    paramStructMsgForImageShare = paramStructMsgForImageShare.getFirstImageElement();
    if (paramStructMsgForImageShare == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, "handleAppShareAction firstImageElement NULL!!!");
      }
      return false;
    }
    String str = paramQQAppInterface.getCurrentAccountUin();
    MessageRecord localMessageRecord = MessageRecordFactory.a(paramMessageRecord);
    paramQQAppInterface.getMessageFacade().a(localMessageRecord, str);
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mSelfUin = str;
    localTransferRequest.mPeerUin = paramMessageRecord.frienduin;
    localTransferRequest.mUinType = paramMessageRecord.istroop;
    localTransferRequest.mFileType = 1;
    localTransferRequest.mUniseq = localMessageRecord.uniseq;
    localTransferRequest.mIsUp = true;
    localTransferRequest.mBusiType = 1030;
    localTransferRequest.mLocalPath = paramStructMsgForImageShare.ac;
    ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(localTransferRequest);
    return true;
  }
  
  public static final String scaleLocalImage(Context paramContext, ImageInfo paramImageInfo, String paramString, int paramInt)
  {
    if ((paramContext != null) && (paramImageInfo != null))
    {
      if (paramString == null) {
        return null;
      }
      Object localObject = new File(paramString);
      if (!((File)localObject).exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("StructMsg", 2, "handleAppShareAction mShareImageUrl NULL!!!");
        }
        return null;
      }
      try
      {
        if ((!GifDrawable.isGifFile((File)localObject)) || (((File)localObject).length() >= 12582912L))
        {
          localObject = new File(AbsStructMsg.ar);
          if (!((File)localObject).exists()) {
            ((File)localObject).mkdirs();
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(AbsStructMsg.ar);
          ((StringBuilder)localObject).append(System.currentTimeMillis());
          ((StringBuilder)localObject).append(".jpg");
          localObject = ((StringBuilder)localObject).toString();
        }
        try
        {
          boolean bool = com.tencent.mobileqq.utils.ImageUtil.a(4, paramContext, paramString, (String)localObject, true, paramImageInfo, paramInt);
          paramContext = (Context)localObject;
          if (bool) {
            break label198;
          }
          paramContext = paramString;
        }
        catch (Exception localException1)
        {
          paramImageInfo = (ImageInfo)localObject;
        }
        paramContext = paramImageInfo;
      }
      catch (Exception localException2)
      {
        paramImageInfo = null;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("StructMsg", 2, localException2.getMessage());
        paramContext = paramImageInfo;
      }
      label198:
      if (TextUtils.isEmpty(paramContext)) {
        return null;
      }
      if (QLog.isColorLevel()) {
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
          long l1 = new File(paramString).length();
          long l2 = new File(paramContext).length();
          paramImageInfo = new StringBuilder();
          paramImageInfo.append("srcBmp = ");
          paramImageInfo.append(paramString);
          paramImageInfo.append(", length = ");
          paramImageInfo.append(l1);
          paramImageInfo.append(", srcWidth = ");
          paramImageInfo.append(paramInt);
          paramImageInfo.append(", srcHeight = ");
          paramImageInfo.append(i);
          paramImageInfo.append(", destBmp = ");
          paramImageInfo.append(paramContext);
          paramImageInfo.append(", length = ");
          paramImageInfo.append(l2);
          paramImageInfo.append(", destWidth = ");
          paramImageInfo.append(j);
          paramImageInfo.append(", distHeight = ");
          paramImageInfo.append(k);
          QLog.d("StructMsg", 2, paramImageInfo.toString());
          return paramContext;
        }
        catch (Exception paramImageInfo)
        {
          QLog.d("StructMsg", 2, paramImageInfo.getMessage());
        }
      }
      return paramContext;
    }
    return null;
  }
  
  public static boolean sendAndUploadImageShare(QQAppInterface paramQQAppInterface, StructMsgForImageShare paramStructMsgForImageShare, String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    return sendAndUploadImageShare(paramQQAppInterface, paramStructMsgForImageShare, paramString1, paramInt1, paramString2, paramInt2, null, false);
  }
  
  public static boolean sendAndUploadImageShare(QQAppInterface paramQQAppInterface, StructMsgForImageShare paramStructMsgForImageShare, String paramString1, int paramInt1, String paramString2, int paramInt2, UpCallBack paramUpCallBack, boolean paramBoolean)
  {
    if (paramStructMsgForImageShare == null) {
      return false;
    }
    if ((paramString1 != null) && (paramInt1 >= 0))
    {
      StructMsgItemImage localStructMsgItemImage = paramStructMsgForImageShare.getFirstImageElement();
      if (localStructMsgItemImage == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StructMsg", 2, "handleAppShareAction firstImageElement NULL!!!");
        }
        return false;
      }
      int i = MobileQQService.seq;
      MobileQQService.seq = i + 1;
      long l = i;
      String str = paramQQAppInterface.getCurrentAccountUin();
      if (((paramInt1 != 1000) && (paramInt1 != 1020) && (paramInt1 != 1004)) || (TextUtils.isEmpty(paramString2))) {
        paramString2 = str;
      }
      localStructMsgItemImage.d = 0L;
      paramString2 = MessageRecordFactory.a(paramQQAppInterface, str, paramString1, paramString2, paramInt1, l, paramStructMsgForImageShare);
      ForwardOrderManager.a().a(paramString2.uniseq, paramStructMsgForImageShare.uniseq, paramStructMsgForImageShare.forwardID);
      if (UinTypeUtil.a(paramInt1) == 1032) {
        ConfessMsgUtil.a(paramQQAppInterface, paramString2, paramString1, paramInt1, paramInt2);
      }
      if (!paramStructMsgForImageShare.checkImageSharePic(paramQQAppInterface.getApp())) {
        return false;
      }
      if (FileUtils.isLocalPath(localStructMsgItemImage.ac))
      {
        paramStructMsgForImageShare = HexUtil.bytes2HexStr(MD5.getFileMd5(localStructMsgItemImage.ac));
        if (paramStructMsgForImageShare == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, "handleAppShareAction MD5 NULL!!!");
          }
          return false;
        }
        localStructMsgItemImage.ae = paramStructMsgForImageShare;
        paramStructMsgForImageShare = ((IPicHelper)QRoute.api(IPicHelper.class)).getURL(paramStructMsgForImageShare, 1);
        if (paramStructMsgForImageShare == null) {
          paramStructMsgForImageShare = null;
        } else {
          paramStructMsgForImageShare = paramStructMsgForImageShare.toString();
        }
        if (!AbsDownloader.hasFile(paramStructMsgForImageShare))
        {
          paramStructMsgForImageShare = AbsDownloader.getFilePath(paramStructMsgForImageShare);
          FileUtils.copyFile(localStructMsgItemImage.ac, paramStructMsgForImageShare);
        }
      }
      paramStructMsgForImageShare = new TransferRequest();
      paramStructMsgForImageShare.mSelfUin = str;
      paramStructMsgForImageShare.mPeerUin = paramString1;
      paramStructMsgForImageShare.mUinType = paramInt1;
      paramStructMsgForImageShare.mFileType = 1;
      paramStructMsgForImageShare.mUniseq = paramString2.uniseq;
      paramStructMsgForImageShare.mIsUp = true;
      paramStructMsgForImageShare.mBusiType = 1030;
      paramStructMsgForImageShare.mLocalPath = localStructMsgItemImage.ac;
      paramStructMsgForImageShare.mUpCallBack = paramUpCallBack;
      if (paramBoolean)
      {
        paramStructMsgForImageShare.needSendMsg = false;
        paramStructMsgForImageShare.isShareImageByServer = true;
      }
      else
      {
        paramQQAppInterface.getMessageFacade().a(paramString2, str);
      }
      ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(paramStructMsgForImageShare);
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StructMsg", 2, "handleAppShareAction toUin is NULL!!!");
    }
    return false;
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
        localStructMsgItemImage.ac = ((MessageForPic)localObject2).path;
      }
      else
      {
        Object localObject1 = null;
        paramContext = localURLDrawable.getURL().toString();
        if (AbsDownloader.hasFile(paramContext))
        {
          localObject2 = AbsDownloader.getFile(paramContext);
          paramContext = localObject1;
          if (localObject2 != null)
          {
            paramContext = localObject1;
            if (((File)localObject2).exists()) {
              paramContext = ((File)localObject2).getAbsolutePath();
            }
          }
        }
        else
        {
          localObject2 = AbsDownloader.getFile(URLDrawableHelper.getURL((PicUiInterface)localObject2, 65537).toString());
          paramContext = localObject1;
          if (localObject2 != null)
          {
            paramContext = localObject1;
            if (((File)localObject2).exists()) {
              paramContext = ((File)localObject2).getAbsolutePath();
            }
          }
        }
        localStructMsgItemImage.ac = paramContext;
      }
      if (TextUtils.isEmpty(localStructMsgItemImage.ac))
      {
        if (QLog.isColorLevel()) {
          QLog.d("StructMsg", 2, "StructingMsgItemBuilder onMenuItemClicked forward imageElement.mShareImageUrl is null!!!");
        }
        return false;
      }
      if (!AbsDownloader.hasFile(localURLDrawable.getURL().toString())) {
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
    int j = i * 140;
    paramView.setMaxHeight(j);
    paramView.setAdjustViewBounds(true);
    paramView.setPadding(0, 10, 0, 10);
    Object localObject2 = new LinearLayout.LayoutParams(-1, -2);
    ((LinearLayout.LayoutParams)localObject2).gravity = 17;
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    paramView.setMinimumHeight(i * 120);
    if (ChatActivityConstants.a) {
      paramView.setContentDescription(paramContext.getString(2131717617));
    }
    paramContext = ((Resources)localObject1).getDrawable(2130850831);
    localObject1 = getFirstImageElement();
    if ((localObject1 != null) && (((StructMsgItemImage)localObject1).ac != null))
    {
      localObject2 = ((StructMsgItemImage)localObject1).ac;
      if ((!((String)localObject2).startsWith("http://")) && (!((String)localObject2).startsWith("https://")))
      {
        localObject2 = com.tencent.biz.common.util.ImageUtil.a(((StructMsgItemImage)localObject1).ac, j);
        if (localObject2 != null)
        {
          paramView.setImageBitmap(com.tencent.mobileqq.utils.ImageUtil.a((Bitmap)localObject2, new File(((StructMsgItemImage)localObject1).ac)));
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
  
  public String getTitleFromBrief()
  {
    if (TextUtils.isEmpty(this.mMsgBrief)) {
      return "";
    }
    if (this.mMsgBrief.startsWith("[分享]")) {
      return this.mMsgBrief.substring(4);
    }
    return this.mMsgBrief;
  }
  
  public View getView(Context paramContext, View paramView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, Bundle paramBundle)
  {
    if (this.mMsgException)
    {
      paramContext = getVersionExceptionView(paramContext, paramView, paramOnLongClickAndTouchListener, paramBundle);
      paramContext.setId(2131377989);
      paramContext.setTag(2131377989, this);
      return paramContext;
    }
    paramOnLongClickAndTouchListener = (ViewGroup)super.getView(paramContext, paramView, paramOnLongClickAndTouchListener, paramBundle);
    StructMsgItemImage localStructMsgItemImage = getFirstImageElement();
    if (localStructMsgItemImage != null)
    {
      localStructMsgItemImage.a = this;
      if ((paramOnLongClickAndTouchListener.getChildCount() == 1) && ((paramOnLongClickAndTouchListener.getChildAt(0) instanceof BubbleImageView)) && (localStructMsgItemImage.a())) {
        localStructMsgItemImage.a(paramContext, paramOnLongClickAndTouchListener.getChildAt(0), paramBundle);
      } else {
        paramOnLongClickAndTouchListener.addView(localStructMsgItemImage.a(paramContext, paramView, paramBundle));
      }
    }
    paramContext = paramOnLongClickAndTouchListener.getLayoutParams();
    if (paramContext == null)
    {
      paramContext = new LinearLayout.LayoutParams(-2, -2);
    }
    else
    {
      paramContext.height = -2;
      paramContext.width = -2;
    }
    paramOnLongClickAndTouchListener.setLayoutParams(paramContext);
    paramOnLongClickAndTouchListener.setBackgroundDrawable(null);
    paramOnLongClickAndTouchListener.setId(2131377989);
    paramOnLongClickAndTouchListener.setTag(2131377989, this);
    return paramOnLongClickAndTouchListener;
  }
  
  protected boolean parseContentNode(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    if ("item".equals(paramStructMsgNode.b)) {
      localObject = paramStructMsgNode.a("layout");
    }
    try
    {
      int i;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        i = Integer.parseInt((String)localObject);
      } else {
        i = 0;
      }
      localObject = StructMsgElementFactory.a(i);
    }
    catch (NumberFormatException paramStructMsgNode)
    {
      label52:
      break label52;
    }
    if (QLog.isColorLevel())
    {
      paramStructMsgNode = new StringBuilder();
      paramStructMsgNode.append("Item layout value is ");
      paramStructMsgNode.append(0);
      QLog.d("StructMsg", 2, paramStructMsgNode.toString());
    }
    return false;
    Object localObject = StructMsgElementFactory.a(paramStructMsgNode.b);
    if (localObject == null) {
      return false;
    }
    if (((AbsStructMsgElement)localObject).a(paramStructMsgNode))
    {
      addItem((AbsStructMsgElement)localObject);
      return true;
    }
    return false;
  }
  
  public void readExternal(ObjectInput paramObjectInput)
  {
    int n;
    label1000:
    do
    {
      for (;;)
      {
        int k;
        int j;
        try
        {
          n = paramObjectInput.readInt();
          this.mVersion = n;
          Object localObject;
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
            if ((!TextUtils.isEmpty(this.mSourceName)) || (!TextUtils.isEmpty(this.mSourceIcon))) {
              this.mHasSource = true;
            }
          }
          else
          {
            if (n >= 2)
            {
              this.mMsgTemplateID = paramObjectInput.readInt();
              this.mMsgAction = paramObjectInput.readUTF();
              this.mMsgActionData = paramObjectInput.readUTF();
              this.mMsg_A_ActionData = paramObjectInput.readUTF();
              this.mMsg_I_ActionData = paramObjectInput.readUTF();
              this.mMsgUrl = paramObjectInput.readUTF();
              this.mMsgBrief = paramObjectInput.readUTF();
              int i1 = paramObjectInput.readInt();
              int m = 0;
              k = 0;
              i = 1;
              if (k < i1)
              {
                localObject = paramObjectInput.readUTF();
                if ("item".equals(localObject))
                {
                  localObject = StructMsgElementFactory.a(paramObjectInput.readInt());
                }
                else
                {
                  AbsStructMsgElement localAbsStructMsgElement = StructMsgElementFactory.a((String)localObject);
                  localObject = localAbsStructMsgElement;
                  if (localAbsStructMsgElement != null)
                  {
                    localObject = localAbsStructMsgElement;
                    if (AbsStructMsgItem.class.isInstance(localAbsStructMsgElement))
                    {
                      paramObjectInput.readInt();
                      localObject = localAbsStructMsgElement;
                    }
                  }
                }
                j = i;
                if (localObject == null) {
                  break label1000;
                }
                ((AbsStructMsgElement)localObject).a(paramObjectInput);
                j = i;
                if (!TextUtils.isEmpty(((AbsStructMsgElement)localObject).c))
                {
                  ((AbsStructMsgElement)localObject).aa = String.valueOf(i);
                  j = i + 1;
                }
                ((AbsStructMsgElement)localObject).ab = this.uin;
                addItem((AbsStructMsgElement)localObject);
                break label1000;
              }
              this.mSourceAppid = paramObjectInput.readLong();
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
              if (n < 3) {
                return;
              }
              this.mCompatibleText = paramObjectInput.readUTF();
              this.msgId = paramObjectInput.readLong();
              this.mPromotionType = paramObjectInput.readInt();
              this.mPromotionMsg = paramObjectInput.readUTF();
              this.mPromotionMenus = paramObjectInput.readUTF();
              this.mPromotionMenuDestructiveIndex = paramObjectInput.readInt();
              i = m;
              if (i >= this.mStructMsgItemLists.size()) {
                break;
              }
              localObject = (AbsStructMsgElement)this.mStructMsgItemLists.get(i);
              ((AbsStructMsgElement)localObject).a = this.msgId;
              ((AbsStructMsgElement)localObject).n = this.mPromotionType;
              i += 1;
              continue;
              this.source_puin = paramObjectInput.readUTF();
              if (n < 7) {
                return;
              }
              this.adverSign = paramObjectInput.readInt();
              this.adverKey = paramObjectInput.readUTF();
              this.index = paramObjectInput.readUTF();
              this.index_name = paramObjectInput.readUTF();
              this.index_type = paramObjectInput.readUTF();
              if (n < 16) {
                return;
              }
              this.thumbWidth = paramObjectInput.readInt();
              this.thumbHeight = paramObjectInput.readInt();
              this.mImageBizType = paramObjectInput.readInt();
              if (n < 20) {
                return;
              }
              this.rawUrl = paramObjectInput.readUTF();
              if (n < 21) {
                return;
              }
              this.bigUrl = paramObjectInput.readUTF();
              this.thumbUrl = paramObjectInput.readUTF();
              if (n < 26) {
                return;
              }
              this.width = paramObjectInput.readInt();
              this.height = paramObjectInput.readInt();
              return;
            }
            this.mMsgException = true;
            return;
          }
        }
        catch (IOException paramObjectInput)
        {
          if ((paramObjectInput.getMessage() != null) && (paramObjectInput.getMessage().equals("structmsg_version_error"))) {
            this.mMsgException = true;
          }
          paramObjectInput.printStackTrace();
        }
        return;
        k += 1;
        int i = j;
      }
    } while (n >= 5);
  }
  
  public void report(Object paramObject)
  {
    StructMsgItemImage localStructMsgItemImage = getFirstImageElement();
    if (localStructMsgItemImage != null)
    {
      if (!localStructMsgItemImage.a()) {
        return;
      }
      if (!(paramObject instanceof Long)) {
        return;
      }
      SdkShareReporter.a(this.uinType, this.mSourceAppid, getTitleFromBrief());
    }
  }
  
  protected void setCompoundDrawable(TextView paramTextView, Drawable paramDrawable, Resources paramResources)
  {
    StructMsgItemImage localStructMsgItemImage = getFirstImageElement();
    if ((localStructMsgItemImage != null) && (localStructMsgItemImage.a()))
    {
      ThreadManagerV2.executeOnSubThread(new StructMsgForImageShare.2(this, paramDrawable, paramResources, paramTextView));
      return;
    }
    super.setCompoundDrawable(paramTextView, paramDrawable, paramResources);
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
    if (this.mMsgAction == null) {
      localObject = "";
    } else {
      localObject = this.mMsgAction;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mMsgActionData == null) {
      localObject = "";
    } else {
      localObject = this.mMsgActionData;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mMsg_A_ActionData == null) {
      localObject = "";
    } else {
      localObject = this.mMsg_A_ActionData;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mMsg_I_ActionData == null) {
      localObject = "";
    } else {
      localObject = this.mMsg_I_ActionData;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mMsgUrl == null) {
      localObject = "";
    } else {
      localObject = this.mMsgUrl;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mMsgBrief == null) {
      localObject = "";
    } else {
      localObject = this.mMsgBrief;
    }
    paramObjectOutput.writeUTF((String)localObject);
    paramObjectOutput.writeInt(getItemCount());
    Object localObject = iterator();
    while (((Iterator)localObject).hasNext()) {
      ((AbsStructMsgElement)((Iterator)localObject).next()).a(paramObjectOutput);
    }
    paramObjectOutput.writeLong(this.mSourceAppid);
    if (this.mSourceIcon == null) {
      localObject = "";
    } else {
      localObject = this.mSourceIcon;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mSourceName == null) {
      localObject = "";
    } else {
      localObject = this.mSourceName;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mSourceUrl == null) {
      localObject = "";
    } else {
      localObject = this.mSourceUrl;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mSourceAction == null) {
      localObject = "";
    } else {
      localObject = this.mSourceAction;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mSourceActionData == null) {
      localObject = "";
    } else {
      localObject = this.mSourceActionData;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mSource_A_ActionData == null) {
      localObject = "";
    } else {
      localObject = this.mSource_A_ActionData;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mSource_I_ActionData == null) {
      localObject = "";
    } else {
      localObject = this.mSource_I_ActionData;
    }
    paramObjectOutput.writeUTF((String)localObject);
    paramObjectOutput.writeInt(this.fwFlag);
    paramObjectOutput.writeInt(this.mFlag);
    paramObjectOutput.writeBoolean(this.mHasSource);
    if (this.mCommentText == null) {
      localObject = "";
    } else {
      localObject = this.mCommentText;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mCompatibleText == null) {
      localObject = "";
    } else {
      localObject = this.mCompatibleText;
    }
    paramObjectOutput.writeUTF((String)localObject);
    paramObjectOutput.writeLong(this.msgId);
    paramObjectOutput.writeInt(this.mPromotionType);
    if (this.mPromotionMsg == null) {
      localObject = "";
    } else {
      localObject = this.mPromotionMsg;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.mPromotionMenus == null) {
      localObject = "";
    } else {
      localObject = this.mPromotionMenus;
    }
    paramObjectOutput.writeUTF((String)localObject);
    paramObjectOutput.writeInt(this.mPromotionMenuDestructiveIndex);
    if (this.source_puin == null) {
      localObject = "";
    } else {
      localObject = this.source_puin;
    }
    paramObjectOutput.writeUTF((String)localObject);
    paramObjectOutput.writeInt(this.adverSign);
    if (this.adverKey == null) {
      localObject = "";
    } else {
      localObject = this.adverKey;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.index == null) {
      localObject = "";
    } else {
      localObject = this.index;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.index_name == null) {
      localObject = "";
    } else {
      localObject = this.index_name;
    }
    paramObjectOutput.writeUTF((String)localObject);
    if (this.index_type == null) {
      localObject = "";
    } else {
      localObject = this.index_type;
    }
    paramObjectOutput.writeUTF((String)localObject);
    paramObjectOutput.writeInt(this.thumbWidth);
    paramObjectOutput.writeInt(this.thumbHeight);
    paramObjectOutput.writeInt(this.mImageBizType);
    String str = this.rawUrl;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    paramObjectOutput.writeUTF((String)localObject);
    str = this.bigUrl;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    paramObjectOutput.writeUTF((String)localObject);
    str = this.thumbUrl;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    paramObjectOutput.writeUTF((String)localObject);
    paramObjectOutput.writeInt(this.width);
    paramObjectOutput.writeInt(this.height);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForImageShare
 * JD-Core Version:    0.7.0.1
 */