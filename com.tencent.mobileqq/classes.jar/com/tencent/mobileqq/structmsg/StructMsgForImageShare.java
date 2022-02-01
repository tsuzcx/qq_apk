package com.tencent.mobileqq.structmsg;

import adak;
import aeam;
import agjk;
import agsg;
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
import aqyt;
import azpd;
import azpe;
import azqr;
import azrg;
import bcpt;
import bcry;
import bdll;
import bdok;
import bdol;
import bdom;
import bdov;
import bdpn;
import bdqc;
import bdqo;
import bdqr;
import bdtj;
import beqz;
import beyb;
import beyg;
import beyq;
import bhmi;
import bhmq;
import com.qq.taf.jce.HexUtil;
import com.tencent.image.GifDrawable;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.photo.ImageInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.widget.BubbleImageView;
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
import nnw;

public class StructMsgForImageShare
  extends AbsShareMsg
{
  public static final int SHARE_IMAGE_FREVIEW_MAX_SZIE = 140;
  private static View.OnClickListener a = new bdpn();
  public String bigUrl;
  public int height;
  public int mImageBizType;
  public int mIsSend = 1;
  public int mMsgType;
  public long mUniseq;
  public String rawUrl;
  public int thumbHeight;
  public String thumbUrl;
  public int thumbWidth;
  public int width;
  
  public StructMsgForImageShare()
  {
    this.mMsgServiceID = 5;
  }
  
  public StructMsgForImageShare(Bundle paramBundle)
  {
    super(paramBundle);
    if (paramBundle.getInt("req_type", 1) != 5) {
      return;
    }
    this.mMsgServiceID = 5;
    bdom localbdom = bdov.a(0);
    localbdom.b(paramBundle.getString("image_url"));
    this.mStructMsgItemLists.add(localbdom);
    this.thumbWidth = paramBundle.getInt("struct_share_key_thumb_width", 0);
    this.thumbHeight = paramBundle.getInt("struct_share_key_thumb_height", 0);
  }
  
  public StructMsgForImageShare(bdqc parambdqc)
  {
    super(parambdqc);
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
    MessageRecord localMessageRecord = bcry.a(paramMessageRecord);
    paramQQAppInterface.a().a(localMessageRecord, str);
    beyg localbeyg = new beyg();
    localbeyg.jdField_b_of_type_JavaLangString = str;
    localbeyg.c = paramMessageRecord.frienduin;
    localbeyg.jdField_a_of_type_Int = paramMessageRecord.istroop;
    localbeyg.jdField_b_of_type_Int = 1;
    localbeyg.jdField_a_of_type_Long = localMessageRecord.uniseq;
    localbeyg.jdField_a_of_type_Boolean = true;
    localbeyg.e = 1030;
    localbeyg.i = paramStructMsgForImageShare.ac;
    paramQQAppInterface.a().a(localbeyg, localMessageRecord);
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
        localFile = new File(AbsStructMsg.ar);
        str1 = str2;
        if (!localFile.exists())
        {
          str1 = str2;
          localFile.mkdirs();
        }
        str1 = str2;
        str2 = AbsStructMsg.ar + System.currentTimeMillis() + ".jpg";
        str1 = str2;
        bool = bhmq.a(4, paramContext, paramString, str2, true, paramImageInfo, paramInt);
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
    return sendAndUploadImageShare(paramQQAppInterface, paramStructMsgForImageShare, paramString1, paramInt1, paramString2, paramInt2, null, false);
  }
  
  public static boolean sendAndUploadImageShare(QQAppInterface paramQQAppInterface, StructMsgForImageShare paramStructMsgForImageShare, String paramString1, int paramInt1, String paramString2, int paramInt2, azrg paramazrg, boolean paramBoolean)
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
    bdqr localbdqr = paramStructMsgForImageShare.getFirstImageElement();
    if (localbdqr == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, "handleAppShareAction firstImageElement NULL!!!");
      }
      return false;
    }
    int i = bcpt.jdField_a_of_type_Int;
    bcpt.jdField_a_of_type_Int = i + 1;
    long l = i;
    String str = paramQQAppInterface.getCurrentAccountUin();
    if (((paramInt1 != 1000) && (paramInt1 != 1020) && (paramInt1 != 1004)) || (TextUtils.isEmpty(paramString2))) {
      paramString2 = str;
    }
    for (;;)
    {
      localbdqr.d = 0L;
      paramString2 = bcry.a(paramQQAppInterface, str, paramString1, paramString2, paramInt1, l, paramStructMsgForImageShare);
      agsg.a().a(paramString2.uniseq, paramStructMsgForImageShare.uniseq, paramStructMsgForImageShare.forwardID);
      if (adak.a(paramInt1) == 1032) {
        aqyt.a(paramQQAppInterface, paramString2, paramString1, paramInt1, paramInt2);
      }
      if (!paramStructMsgForImageShare.checkImageSharePic(paramQQAppInterface.getApp())) {
        return false;
      }
      if (bhmi.c(localbdqr.ac))
      {
        paramStructMsgForImageShare = HexUtil.bytes2HexStr(MD5.getFileMd5(localbdqr.ac));
        if (paramStructMsgForImageShare == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, "handleAppShareAction MD5 NULL!!!");
          }
          return false;
        }
        localbdqr.ae = paramStructMsgForImageShare;
        paramStructMsgForImageShare = beyq.a(paramStructMsgForImageShare, 1);
        if (paramStructMsgForImageShare != null) {
          break label362;
        }
        paramStructMsgForImageShare = null;
        if (!beqz.b(paramStructMsgForImageShare))
        {
          paramStructMsgForImageShare = beqz.d(paramStructMsgForImageShare);
          bhmi.d(localbdqr.ac, paramStructMsgForImageShare);
        }
      }
      paramStructMsgForImageShare = new beyg();
      paramStructMsgForImageShare.jdField_b_of_type_JavaLangString = str;
      paramStructMsgForImageShare.c = paramString1;
      paramStructMsgForImageShare.jdField_a_of_type_Int = paramInt1;
      paramStructMsgForImageShare.jdField_b_of_type_Int = 1;
      paramStructMsgForImageShare.jdField_a_of_type_Long = paramString2.uniseq;
      paramStructMsgForImageShare.jdField_a_of_type_Boolean = true;
      paramStructMsgForImageShare.e = 1030;
      paramStructMsgForImageShare.i = localbdqr.ac;
      paramStructMsgForImageShare.jdField_a_of_type_Azrg = paramazrg;
      if (paramBoolean)
      {
        paramStructMsgForImageShare.f = false;
        paramStructMsgForImageShare.r = true;
      }
      for (;;)
      {
        paramQQAppInterface.a().a(paramStructMsgForImageShare);
        return true;
        label362:
        paramStructMsgForImageShare = paramStructMsgForImageShare.toString();
        break;
        paramQQAppInterface.a().a(paramString2, str);
      }
    }
  }
  
  public static boolean sendAndUploadImageShareHotPic(QQAppInterface paramQQAppInterface, StructMsgForImageShare paramStructMsgForImageShare, String paramString1, int paramInt1, String paramString2, azpe paramazpe, int paramInt2)
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
    bdqr localbdqr = paramStructMsgForImageShare.getFirstImageElement();
    if (localbdqr == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, "handleAppShareAction firstImageElement NULL!!!");
      }
      return false;
    }
    int i = bcpt.jdField_a_of_type_Int;
    bcpt.jdField_a_of_type_Int = i + 1;
    long l = i;
    String str = paramQQAppInterface.getCurrentAccountUin();
    if (((paramInt1 != 1000) && (paramInt1 != 1020) && (paramInt1 != 1004)) || (TextUtils.isEmpty(paramString2))) {
      paramString2 = str;
    }
    for (;;)
    {
      localbdqr.d = 0L;
      paramString2 = bcry.a(paramQQAppInterface, str, paramString1, paramString2, paramInt1, l, paramStructMsgForImageShare);
      azpd.a(paramString2, paramazpe);
      if (adak.a(paramInt1) == 1032) {
        aqyt.a(paramQQAppInterface, paramString2, paramString1, paramInt1, paramInt2);
      }
      paramQQAppInterface.a().a(paramString2, str);
      if (bhmi.c(localbdqr.ac))
      {
        paramStructMsgForImageShare = HexUtil.bytes2HexStr(MD5.getFileMd5(localbdqr.ac));
        if (paramStructMsgForImageShare == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, "handleAppShareAction MD5 NULL!!!");
          }
          return false;
        }
        paramStructMsgForImageShare = beyq.a(paramStructMsgForImageShare, 1);
        if (paramStructMsgForImageShare != null) {
          break label323;
        }
      }
      label323:
      for (paramStructMsgForImageShare = null;; paramStructMsgForImageShare = paramStructMsgForImageShare.toString())
      {
        if (!beqz.b(paramStructMsgForImageShare))
        {
          paramStructMsgForImageShare = beqz.d(paramStructMsgForImageShare);
          bhmi.d(localbdqr.ac, paramStructMsgForImageShare);
        }
        paramStructMsgForImageShare = new beyg();
        paramStructMsgForImageShare.jdField_b_of_type_JavaLangString = str;
        paramStructMsgForImageShare.c = paramString1;
        paramStructMsgForImageShare.jdField_a_of_type_Int = paramInt1;
        paramStructMsgForImageShare.jdField_b_of_type_Int = 1;
        paramStructMsgForImageShare.jdField_a_of_type_Long = paramString2.uniseq;
        paramStructMsgForImageShare.jdField_a_of_type_Boolean = true;
        paramStructMsgForImageShare.e = 1030;
        paramStructMsgForImageShare.i = localbdqr.ac;
        paramQQAppInterface.a().a(paramStructMsgForImageShare, paramString2);
        return true;
      }
    }
  }
  
  public boolean checkImageSharePic(Context paramContext)
  {
    bdqr localbdqr = getFirstImageElement();
    if (localbdqr != null)
    {
      if (localbdqr.a == null) {
        localbdqr.a = this;
      }
      Object localObject2 = localbdqr.a();
      URLDrawable localURLDrawable = ForwardUtils.a(paramContext, (MessageForPic)localObject2);
      if (new File(((MessageForPic)localObject2).path).exists())
      {
        localbdqr.ac = ((MessageForPic)localObject2).path;
        if (TextUtils.isEmpty(localbdqr.ac))
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
        if (beqz.b(paramContext))
        {
          localObject2 = beqz.a(paramContext);
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
          localbdqr.ac = paramContext;
          break;
          localObject2 = beqz.a(beyq.a((azqr)localObject2, 65537).toString());
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
      if (!beqz.b(localURLDrawable.getURL().toString())) {
        localURLDrawable.startDownload();
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StructMsg", 2, "StructingMsgItemBuilder onMenuItemClicked forward imageElement is null!!!");
    }
    return false;
  }
  
  public bdqr getFirstImageElement()
  {
    if (this.mStructMsgItemLists != null)
    {
      int i = 0;
      while (i < this.mStructMsgItemLists.size())
      {
        Object localObject = (bdol)this.mStructMsgItemLists.get(i);
        if ((localObject instanceof bdom))
        {
          localObject = (bdom)localObject;
          if (((bdom)localObject).a != null)
          {
            int j = 0;
            while (j < ((bdom)localObject).a.size())
            {
              bdol localbdol = (bdol)((bdom)localObject).a.get(j);
              if ((localbdol != null) && ((localbdol instanceof bdqr))) {
                return (bdqr)localbdol;
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
    paramView.setMaxHeight(i * 140);
    paramView.setAdjustViewBounds(true);
    paramView.setPadding(0, 10, 0, 10);
    Object localObject2 = new LinearLayout.LayoutParams(-1, -2);
    ((LinearLayout.LayoutParams)localObject2).gravity = 17;
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    paramView.setMinimumHeight(i * 120);
    if (aeam.R) {
      paramView.setContentDescription(paramContext.getString(2131716866));
    }
    paramContext = ((Resources)localObject1).getDrawable(2130850460);
    localObject1 = getFirstImageElement();
    if ((localObject1 != null) && (((bdqr)localObject1).ac != null))
    {
      localObject2 = ((bdqr)localObject1).ac;
      if ((!((String)localObject2).startsWith("http://")) && (!((String)localObject2).startsWith("https://")))
      {
        localObject2 = nnw.a(((bdqr)localObject1).ac, i * 140);
        if (localObject2 != null)
        {
          paramView.setImageBitmap(bhmq.a((Bitmap)localObject2, new File(((bdqr)localObject1).ac)));
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
  
  public View getView(Context paramContext, View paramView, agjk paramagjk, Bundle paramBundle)
  {
    if (this.mMsgException)
    {
      paramContext = getVersionExceptionView(paramContext, paramView, paramagjk, paramBundle);
      paramContext.setId(2131378101);
      paramContext.setTag(2131378101, this);
      return paramContext;
    }
    paramagjk = (ViewGroup)super.getView(paramContext, paramView, paramagjk, paramBundle);
    bdqr localbdqr = getFirstImageElement();
    if (localbdqr != null)
    {
      localbdqr.a = this;
      if ((paramagjk.getChildCount() == 1) && ((paramagjk.getChildAt(0) instanceof BubbleImageView)) && (localbdqr.a())) {
        localbdqr.a(paramContext, paramagjk.getChildAt(0), paramBundle);
      }
    }
    else
    {
      paramContext = paramagjk.getLayoutParams();
      if (paramContext != null) {
        break label168;
      }
      paramContext = new LinearLayout.LayoutParams(-2, -2);
    }
    for (;;)
    {
      paramagjk.setLayoutParams(paramContext);
      paramagjk.setBackgroundDrawable(null);
      paramagjk.setId(2131378101);
      paramagjk.setTag(2131378101, this);
      return paramagjk;
      paramagjk.addView(localbdqr.a(paramContext, paramView, paramBundle));
      break;
      label168:
      paramContext.height = -2;
      paramContext.width = -2;
    }
  }
  
  protected boolean parseContentNode(bdqc parambdqc)
  {
    boolean bool2 = false;
    boolean bool1;
    if (parambdqc == null)
    {
      bool1 = true;
      return bool1;
    }
    if ("item".equals(parambdqc.jdField_b_of_type_JavaLangString)) {}
    for (Object localObject = parambdqc.a("layout");; localObject = bdov.a(parambdqc.jdField_b_of_type_JavaLangString))
    {
      try
      {
        if (!TextUtils.isEmpty((CharSequence)localObject)) {}
        for (int i = Integer.parseInt((String)localObject);; i = 0)
        {
          localObject = bdov.a(i);
          bool1 = bool2;
          if (localObject == null) {
            break;
          }
          bool1 = bool2;
          if (!((bdol)localObject).a(parambdqc)) {
            break;
          }
          addItem((bdol)localObject);
          return true;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (NumberFormatException parambdqc)
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
          localObject = bdov.a(this.mContentLayout);
          ((bdom)localObject).a(new bdqo(this.mContentCover));
          ((bdom)localObject).a(new StructMsgItemTitle(this.mContentTitle));
          ((bdom)localObject).a(new bdtj(this.mContentSummary));
          addItem((bdol)localObject);
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
            break label999;
          }
          this.mHasSource = true;
          return;
        }
        if (n < 2) {
          break label994;
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
            localObject = bdov.a(paramObjectInput.readInt());
            j = i;
            if (localObject == null) {
              break label1000;
            }
            ((bdol)localObject).a(paramObjectInput);
            j = i;
            if (!TextUtils.isEmpty(((bdol)localObject).c))
            {
              ((bdol)localObject).aa = String.valueOf(i);
              j = i + 1;
            }
            ((bdol)localObject).ab = this.uin;
            addItem((bdol)localObject);
            break label1000;
          }
          bdol localbdol = bdov.a((String)localObject);
          localObject = localbdol;
          if (localbdol == null) {
            continue;
          }
          localObject = localbdol;
          if (!bdom.class.isInstance(localbdol)) {
            continue;
          }
          paramObjectInput.readInt();
          localObject = localbdol;
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
          localObject = (bdol)this.mStructMsgItemLists.get(i);
          ((bdol)localObject).jdField_a_of_type_Long = this.msgId;
          ((bdol)localObject).n = this.mPromotionType;
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
                  if (n >= 26)
                  {
                    this.width = paramObjectInput.readInt();
                    this.height = paramObjectInput.readInt();
                    return;
                    label994:
                    this.mMsgException = true;
                  }
                }
              }
            }
          }
        }
      }
      label999:
      return;
      label1000:
      k += 1;
      int i = j;
    }
  }
  
  public void report(Object paramObject)
  {
    bdqr localbdqr = getFirstImageElement();
    if ((localbdqr == null) || (!localbdqr.a())) {}
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof Long));
      bdll.b(null, "dc00898", "", "", "0X800A426", "0X800A426", 0, 0, "", ForwardUtils.b(this.uinType), String.valueOf(this.mSourceAppid), "");
    } while (!QLog.isColorLevel());
    QLog.d("StructMsg", 2, "大图曝光=0X800A426, appid=" + this.mSourceAppid);
  }
  
  protected void setCompoundDrawable(TextView paramTextView, Drawable paramDrawable, Resources paramResources)
  {
    bdqr localbdqr = getFirstImageElement();
    if ((localbdqr == null) || (!localbdqr.a()))
    {
      super.setCompoundDrawable(paramTextView, paramDrawable, paramResources);
      return;
    }
    ThreadManagerV2.executeOnSubThread(new StructMsgForImageShare.2(this, paramDrawable, paramResources, paramTextView));
  }
  
  protected void toContentXml(bdok parambdok)
  {
    Iterator localIterator = iterator();
    while (localIterator.hasNext()) {
      ((bdol)localIterator.next()).a(parambdok);
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
        ((bdol)((Iterator)localObject).next()).a(paramObjectOutput);
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
        break label707;
      }
      localObject = "";
      label265:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSourceUrl != null) {
        break label715;
      }
      localObject = "";
      label283:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSourceAction != null) {
        break label723;
      }
      localObject = "";
      label301:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSourceActionData != null) {
        break label731;
      }
      localObject = "";
      label319:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSource_A_ActionData != null) {
        break label739;
      }
      localObject = "";
      label337:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSource_I_ActionData != null) {
        break label747;
      }
      localObject = "";
      label355:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.fwFlag);
      paramObjectOutput.writeInt(this.mFlag);
      paramObjectOutput.writeBoolean(this.mHasSource);
      if (this.mCommentText != null) {
        break label755;
      }
      localObject = "";
      label403:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mCompatibleText != null) {
        break label763;
      }
      localObject = "";
      label421:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeLong(this.msgId);
      paramObjectOutput.writeInt(this.mPromotionType);
      if (this.mPromotionMsg != null) {
        break label771;
      }
      localObject = "";
      label459:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mPromotionMenus != null) {
        break label779;
      }
      localObject = "";
      label477:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.mPromotionMenuDestructiveIndex);
      if (this.source_puin != null) {
        break label787;
      }
      localObject = "";
      label505:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.adverSign);
      if (this.adverKey != null) {
        break label795;
      }
      localObject = "";
      label533:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.index != null) {
        break label803;
      }
      localObject = "";
      label551:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.index_name != null) {
        break label811;
      }
      localObject = "";
      label569:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.index_type != null) {
        break label819;
      }
      localObject = "";
      label587:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.thumbWidth);
      paramObjectOutput.writeInt(this.thumbHeight);
      paramObjectOutput.writeInt(this.mImageBizType);
      if (this.rawUrl != null) {
        break label827;
      }
      localObject = "";
      label635:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.bigUrl != null) {
        break label835;
      }
      localObject = "";
      label653:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.thumbUrl != null) {
        break label843;
      }
    }
    label707:
    label843:
    for (localObject = "";; localObject = this.thumbUrl)
    {
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.width);
      paramObjectOutput.writeInt(this.height);
      return;
      localObject = this.mSourceIcon;
      break;
      localObject = this.mSourceName;
      break label265;
      label715:
      localObject = this.mSourceUrl;
      break label283;
      label723:
      localObject = this.mSourceAction;
      break label301;
      label731:
      localObject = this.mSourceActionData;
      break label319;
      label739:
      localObject = this.mSource_A_ActionData;
      break label337;
      label747:
      localObject = this.mSource_I_ActionData;
      break label355;
      label755:
      localObject = this.mCommentText;
      break label403;
      label763:
      localObject = this.mCompatibleText;
      break label421;
      localObject = this.mPromotionMsg;
      break label459;
      localObject = this.mPromotionMenus;
      break label477;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForImageShare
 * JD-Core Version:    0.7.0.1
 */