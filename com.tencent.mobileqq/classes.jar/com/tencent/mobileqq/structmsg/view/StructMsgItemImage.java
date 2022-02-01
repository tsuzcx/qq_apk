package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView.ScaleType;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.pic.PicUiInterface;
import com.tencent.mobileqq.qqgamepub.api.IGameShareUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.CommonImgThumbHelper;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.net.URL;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgItemImage
  extends AbsStructMsgElement
{
  public int aA;
  public long aB = 0L;
  public long aC = 0L;
  public long aD;
  public StructMsgForImageShare aE = null;
  public MessageForPic aF = null;
  public URL aG = null;
  public String au = null;
  public String av;
  public String aw;
  public int ax;
  public int ay;
  public int az;
  
  public StructMsgItemImage()
  {
    this.a = 14;
    this.b = "image";
  }
  
  public StructMsgItemImage(String paramString)
  {
    this();
    this.au = paramString;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    paramBundle = this.aF;
    if (paramBundle != null)
    {
      paramBundle = URLDrawableHelper.getURL(paramBundle, 65537);
      localObject = this.aG;
      if ((localObject == null) || (!((URL)localObject).equals(paramBundle)))
      {
        paramBundle = PicItemBuilder.a(paramContext, this.aF);
        break label50;
      }
    }
    paramBundle = null;
    label50:
    Object localObject = paramBundle;
    if (paramBundle == null)
    {
      if (this.aE == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StructMsg", 2, "StructMsgItemImage.createView.mImageShareMsg == null nudnik trick");
        }
        return new View(paramContext);
      }
      localObject = new MessageForPic();
      ((MessageForPic)localObject).path = this.au;
      ((MessageForPic)localObject).uuid = this.av;
      ((MessageForPic)localObject).md5 = this.aw;
      ((MessageForPic)localObject).istroop = this.aE.uinType;
      ((MessageForPic)localObject).msgtype = this.aE.mMsgType;
      ((MessageForPic)localObject).versionCode = this.aE.messageVersion;
      ((MessageForPic)localObject).uniseq = this.aE.mUniseq;
      ((MessageForPic)localObject).issend = this.aE.mIsSend;
      ((MessageForPic)localObject).selfuin = this.aE.currentAccountUin;
      ((MessageForPic)localObject).frienduin = this.aE.uin;
      ((MessageForPic)localObject).groupFileID = this.aB;
      ((MessageForPic)localObject).busiType = 1030;
      if (this.aE.mIsSend == 1) {
        paramBundle = this.aE.currentAccountUin;
      } else {
        paramBundle = this.aE.uin;
      }
      ((MessageForPic)localObject).senderuin = paramBundle;
      ((MessageForPic)localObject).size = this.aC;
      ((MessageForPic)localObject).time = this.aD;
      ((MessageForPic)localObject).subVersion = 5;
      ((MessageForPic)localObject).fileSizeFlag = 0;
      ((MessageForPic)localObject).thumbHeight = this.aE.thumbHeight;
      ((MessageForPic)localObject).thumbWidth = this.aE.thumbWidth;
      ((MessageForPic)localObject).rawMsgUrl = this.aE.rawUrl;
      ((MessageForPic)localObject).bigMsgUrl = this.aE.bigUrl;
      ((MessageForPic)localObject).thumbMsgUrl = this.aE.thumbUrl;
      if (c())
      {
        ((MessageForPic)localObject).thumbWidthHeightDP = new ThumbWidthHeightDP(this.ax, this.ay, this.az, this.aA, true);
        ((IGameShareUtil)QRoute.api(IGameShareUtil.class)).tryAdjustThumbSize(this.aE, localObject, this);
      }
      paramBundle = AbsDownloader.getFile(URLDrawableHelper.getURL((PicUiInterface)localObject, 1, null).toString());
      if ((paramBundle != null) && (GifDrawable.isGifFile(paramBundle))) {
        ((MessageForPic)localObject).imageType = 2000;
      }
      this.aF = ((MessageForPic)localObject);
      localObject = PicItemBuilder.a(paramContext, this.aF);
      this.aG = ((URLDrawable)localObject).getURL();
    }
    if ((paramView != null) && ((paramView instanceof BubbleImageView)))
    {
      paramContext = (BubbleImageView)paramView;
    }
    else
    {
      paramView = new BubbleImageView(paramContext);
      paramView.setId(2131435571);
      paramView.setAdjustViewBounds(true);
      int i = this.az;
      if (i != 0) {
        i = AIOUtils.b(i, paramContext.getResources());
      } else {
        i = CommonImgThumbHelper.getImgThumbMaxPx(false);
      }
      paramView.setMaxWidth(i);
      i = this.aA;
      if (i != 0) {
        i = AIOUtils.b(i, paramContext.getResources());
      } else {
        i = CommonImgThumbHelper.getImgThumbMaxPx(false);
      }
      paramView.setMaxHeight(i);
      i = this.ax;
      if (i != 0) {
        paramView.setMinimumWidth(AIOUtils.b(i, paramContext.getResources()));
      }
      i = this.ay;
      if (i != 0) {
        paramView.setMinimumHeight(AIOUtils.b(i, paramContext.getResources()));
      }
      paramView.setAdjustViewBounds(true);
      paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      float f;
      if (QQTheme.isNowSimpleUI()) {
        f = 8.0F;
      } else {
        f = 12.0F;
      }
      paramView.setRadius(f);
      paramContext = paramView;
    }
    paramContext.c(false);
    paramContext.setShowEdge(true);
    paramContext.setImageDrawable((Drawable)localObject);
    ((IGameShareUtil)QRoute.api(IGameShareUtil.class)).tryCompactMaxWidth(this.aE, paramContext, this);
    return paramContext;
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.au = paramObjectInput.readUTF();
    this.av = paramObjectInput.readUTF();
    this.aw = paramObjectInput.readUTF();
    this.aB = paramObjectInput.readLong();
    this.aC = paramObjectInput.readLong();
    this.aD = paramObjectInput.readLong();
    if (this.a > 13)
    {
      this.ax = paramObjectInput.readInt();
      this.ay = paramObjectInput.readInt();
      this.az = paramObjectInput.readInt();
      this.aA = paramObjectInput.readInt();
    }
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    String str2 = this.au;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramObjectOutput.writeUTF(str1);
    str2 = this.av;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramObjectOutput.writeUTF(str1);
    str2 = this.aw;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramObjectOutput.writeUTF(str1);
    paramObjectOutput.writeLong(this.aB);
    paramObjectOutput.writeLong(this.aC);
    paramObjectOutput.writeLong(this.aD);
    if (this.a > 13)
    {
      paramObjectOutput.writeInt(this.ax);
      paramObjectOutput.writeInt(this.ay);
      paramObjectOutput.writeInt(this.az);
      paramObjectOutput.writeInt(this.aA);
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "image");
    String str2 = this.av;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramXmlSerializer.attribute(null, "uuid", str1);
    str2 = this.aw;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramXmlSerializer.attribute(null, "md5", str1);
    paramXmlSerializer.attribute(null, "GroupFiledid", String.valueOf(this.aB));
    paramXmlSerializer.attribute(null, "filesize", String.valueOf(this.aC));
    str2 = this.au;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramXmlSerializer.attribute(null, "local_path", str1);
    paramXmlSerializer.attribute(null, "minWidth", Integer.toString(this.ax));
    paramXmlSerializer.attribute(null, "minHeight", Integer.toString(this.ay));
    paramXmlSerializer.attribute(null, "maxWidth", Integer.toString(this.az));
    paramXmlSerializer.attribute(null, "maxHeight", Integer.toString(this.aA));
    paramXmlSerializer.endTag(null, "image");
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    String str4 = paramStructMsgNode.a("uuid");
    String str3 = paramStructMsgNode.a("md5");
    String str6 = paramStructMsgNode.a("md5");
    String str5 = paramStructMsgNode.a("filesize");
    String str2 = paramStructMsgNode.a("local_path");
    String str1 = str4;
    if (str4 == null) {
      str1 = "";
    }
    this.av = str1;
    str1 = str3;
    if (str3 == null) {
      str1 = "";
    }
    this.aw = str1;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.au = str1;
    this.ax = AIOUtils.a(paramStructMsgNode, "minWidth");
    this.ay = AIOUtils.a(paramStructMsgNode, "minHeight");
    this.az = AIOUtils.a(paramStructMsgNode, "maxWidth");
    this.aA = AIOUtils.a(paramStructMsgNode, "maxHeight");
    if (str6 != null) {
      try
      {
        this.aB = Long.parseLong(str6);
      }
      catch (NumberFormatException paramStructMsgNode)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StructMsg", 2, paramStructMsgNode.getMessage());
        }
      }
    }
    if (str5 != null) {
      try
      {
        this.aC = Long.parseLong(str5);
        return true;
      }
      catch (NumberFormatException paramStructMsgNode)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StructMsg", 2, paramStructMsgNode.getMessage());
        }
      }
    }
    return true;
  }
  
  public String b()
  {
    return "Image";
  }
  
  public boolean c()
  {
    return (this.ax != 0) && (this.ay != 0) && (this.az != 0) && (this.aA != 0);
  }
  
  public MessageForPic d()
  {
    MessageForPic localMessageForPic = new MessageForPic();
    Object localObject = this.aE;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, "StructMsgItemImage.generateMessageForPic.mImageShareMsg == null nudnik trick");
      }
      return localMessageForPic;
    }
    localMessageForPic.path = this.au;
    localMessageForPic.uuid = this.av;
    localMessageForPic.md5 = this.aw;
    localMessageForPic.istroop = ((StructMsgForImageShare)localObject).uinType;
    localMessageForPic.msgtype = this.aE.mMsgType;
    localMessageForPic.versionCode = this.aE.messageVersion;
    localMessageForPic.uniseq = this.aE.mUniseq;
    localMessageForPic.issend = this.aE.mIsSend;
    localMessageForPic.selfuin = this.aE.currentAccountUin;
    localMessageForPic.frienduin = this.aE.uin;
    localMessageForPic.groupFileID = this.aB;
    localMessageForPic.busiType = 1030;
    if (this.aE.mIsSend == 1) {
      localObject = this.aE.currentAccountUin;
    } else {
      localObject = this.aE.uin;
    }
    localMessageForPic.senderuin = ((String)localObject);
    localMessageForPic.size = this.aC;
    localMessageForPic.time = this.aD;
    localMessageForPic.subVersion = 5;
    localMessageForPic.fileSizeFlag = 0;
    localMessageForPic.thumbHeight = this.aE.thumbHeight;
    localMessageForPic.thumbWidth = this.aE.thumbWidth;
    return localMessageForPic;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemImage
 * JD-Core Version:    0.7.0.1
 */