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
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.net.URL;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgItemImage
  extends AbsStructMsgElement
{
  public MessageForPic a;
  public StructMsgForImageShare a;
  public URL a;
  public String ac = null;
  public String ad;
  public String ae;
  public long c = 0L;
  public long d = 0L;
  public long e;
  public int o;
  public int p;
  public int q;
  public int r;
  
  public StructMsgItemImage()
  {
    this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare = null;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = null;
    this.jdField_a_of_type_JavaNetURL = null;
    this.jdField_a_of_type_Int = 14;
    this.jdField_a_of_type_JavaLangString = "image";
  }
  
  public StructMsgItemImage(String paramString)
  {
    this();
    this.ac = paramString;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
    if (paramBundle != null)
    {
      paramBundle = URLDrawableHelper.getURL(paramBundle, 65537);
      localObject = this.jdField_a_of_type_JavaNetURL;
      if ((localObject == null) || (!((URL)localObject).equals(paramBundle)))
      {
        paramBundle = PicItemBuilder.a(paramContext, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic);
        break label50;
      }
    }
    paramBundle = null;
    label50:
    Object localObject = paramBundle;
    if (paramBundle == null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StructMsg", 2, "StructMsgItemImage.createView.mImageShareMsg == null nudnik trick");
        }
        return new View(paramContext);
      }
      localObject = new MessageForPic();
      ((MessageForPic)localObject).path = this.ac;
      ((MessageForPic)localObject).uuid = this.ad;
      ((MessageForPic)localObject).md5 = this.ae;
      ((MessageForPic)localObject).istroop = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.uinType;
      ((MessageForPic)localObject).msgtype = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mMsgType;
      ((MessageForPic)localObject).versionCode = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.messageVersion;
      ((MessageForPic)localObject).uniseq = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mUniseq;
      ((MessageForPic)localObject).issend = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mIsSend;
      ((MessageForPic)localObject).selfuin = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.currentAccountUin;
      ((MessageForPic)localObject).frienduin = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.uin;
      ((MessageForPic)localObject).groupFileID = this.c;
      ((MessageForPic)localObject).busiType = 1030;
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mIsSend == 1) {
        paramBundle = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.currentAccountUin;
      } else {
        paramBundle = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.uin;
      }
      ((MessageForPic)localObject).senderuin = paramBundle;
      ((MessageForPic)localObject).size = this.d;
      ((MessageForPic)localObject).time = this.e;
      ((MessageForPic)localObject).subVersion = 5;
      ((MessageForPic)localObject).fileSizeFlag = 0;
      ((MessageForPic)localObject).thumbHeight = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.thumbHeight;
      ((MessageForPic)localObject).thumbWidth = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.thumbWidth;
      ((MessageForPic)localObject).rawMsgUrl = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.rawUrl;
      ((MessageForPic)localObject).bigMsgUrl = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.bigUrl;
      ((MessageForPic)localObject).thumbMsgUrl = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.thumbUrl;
      if (a())
      {
        ((MessageForPic)localObject).thumbWidthHeightDP = new ThumbWidthHeightDP(this.o, this.p, this.q, this.r, true);
        ((IGameShareUtil)QRoute.api(IGameShareUtil.class)).tryAdjustThumbSize(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare, localObject, this);
      }
      paramBundle = AbsDownloader.getFile(URLDrawableHelper.getURL((PicUiInterface)localObject, 1, null).toString());
      if ((paramBundle != null) && (GifDrawable.isGifFile(paramBundle))) {
        ((MessageForPic)localObject).imageType = 2000;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = ((MessageForPic)localObject);
      localObject = PicItemBuilder.a(paramContext, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic);
      this.jdField_a_of_type_JavaNetURL = ((URLDrawable)localObject).getURL();
    }
    if ((paramView != null) && ((paramView instanceof BubbleImageView)))
    {
      paramContext = (BubbleImageView)paramView;
    }
    else
    {
      paramView = new BubbleImageView(paramContext);
      paramView.setId(2131368658);
      paramView.setAdjustViewBounds(true);
      int i = this.q;
      if (i != 0) {
        i = AIOUtils.b(i, paramContext.getResources());
      } else {
        i = CommonImgThumbHelper.getImgThumbMaxPx(false);
      }
      paramView.setMaxWidth(i);
      i = this.r;
      if (i != 0) {
        i = AIOUtils.b(i, paramContext.getResources());
      } else {
        i = CommonImgThumbHelper.getImgThumbMaxPx(false);
      }
      paramView.setMaxHeight(i);
      i = this.o;
      if (i != 0) {
        paramView.setMinimumWidth(AIOUtils.b(i, paramContext.getResources()));
      }
      i = this.p;
      if (i != 0) {
        paramView.setMinimumHeight(AIOUtils.b(i, paramContext.getResources()));
      }
      paramView.setAdjustViewBounds(true);
      paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramView.setRadius(12.0F);
      paramContext = paramView;
    }
    paramContext.d(false);
    paramContext.setShowEdge(true);
    paramContext.setImageDrawable((Drawable)localObject);
    ((IGameShareUtil)QRoute.api(IGameShareUtil.class)).tryCompactMaxWidth(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare, paramContext, this);
    return paramContext;
  }
  
  public MessageForPic a()
  {
    MessageForPic localMessageForPic = new MessageForPic();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, "StructMsgItemImage.generateMessageForPic.mImageShareMsg == null nudnik trick");
      }
      return localMessageForPic;
    }
    localMessageForPic.path = this.ac;
    localMessageForPic.uuid = this.ad;
    localMessageForPic.md5 = this.ae;
    localMessageForPic.istroop = ((StructMsgForImageShare)localObject).uinType;
    localMessageForPic.msgtype = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mMsgType;
    localMessageForPic.versionCode = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.messageVersion;
    localMessageForPic.uniseq = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mUniseq;
    localMessageForPic.issend = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mIsSend;
    localMessageForPic.selfuin = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.currentAccountUin;
    localMessageForPic.frienduin = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.uin;
    localMessageForPic.groupFileID = this.c;
    localMessageForPic.busiType = 1030;
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mIsSend == 1) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.currentAccountUin;
    } else {
      localObject = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.uin;
    }
    localMessageForPic.senderuin = ((String)localObject);
    localMessageForPic.size = this.d;
    localMessageForPic.time = this.e;
    localMessageForPic.subVersion = 5;
    localMessageForPic.fileSizeFlag = 0;
    localMessageForPic.thumbHeight = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.thumbHeight;
    localMessageForPic.thumbWidth = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.thumbWidth;
    return localMessageForPic;
  }
  
  public String a()
  {
    return "Image";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.ac = paramObjectInput.readUTF();
    this.ad = paramObjectInput.readUTF();
    this.ae = paramObjectInput.readUTF();
    this.c = paramObjectInput.readLong();
    this.d = paramObjectInput.readLong();
    this.e = paramObjectInput.readLong();
    if (this.jdField_a_of_type_Int > 13)
    {
      this.o = paramObjectInput.readInt();
      this.p = paramObjectInput.readInt();
      this.q = paramObjectInput.readInt();
      this.r = paramObjectInput.readInt();
    }
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    String str2 = this.ac;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramObjectOutput.writeUTF(str1);
    str2 = this.ad;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramObjectOutput.writeUTF(str1);
    str2 = this.ae;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramObjectOutput.writeUTF(str1);
    paramObjectOutput.writeLong(this.c);
    paramObjectOutput.writeLong(this.d);
    paramObjectOutput.writeLong(this.e);
    if (this.jdField_a_of_type_Int > 13)
    {
      paramObjectOutput.writeInt(this.o);
      paramObjectOutput.writeInt(this.p);
      paramObjectOutput.writeInt(this.q);
      paramObjectOutput.writeInt(this.r);
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "image");
    String str2 = this.ad;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramXmlSerializer.attribute(null, "uuid", str1);
    str2 = this.ae;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramXmlSerializer.attribute(null, "md5", str1);
    paramXmlSerializer.attribute(null, "GroupFiledid", String.valueOf(this.c));
    paramXmlSerializer.attribute(null, "filesize", String.valueOf(this.d));
    str2 = this.ac;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramXmlSerializer.attribute(null, "local_path", str1);
    paramXmlSerializer.attribute(null, "minWidth", Integer.toString(this.o));
    paramXmlSerializer.attribute(null, "minHeight", Integer.toString(this.p));
    paramXmlSerializer.attribute(null, "maxWidth", Integer.toString(this.q));
    paramXmlSerializer.attribute(null, "maxHeight", Integer.toString(this.r));
    paramXmlSerializer.endTag(null, "image");
  }
  
  public boolean a()
  {
    return (this.o != 0) && (this.p != 0) && (this.q != 0) && (this.r != 0);
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
    this.ad = str1;
    str1 = str3;
    if (str3 == null) {
      str1 = "";
    }
    this.ae = str1;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.ac = str1;
    this.o = AIOUtils.a(paramStructMsgNode, "minWidth");
    this.p = AIOUtils.a(paramStructMsgNode, "minHeight");
    this.q = AIOUtils.a(paramStructMsgNode, "maxWidth");
    this.r = AIOUtils.a(paramStructMsgNode, "maxHeight");
    if (str6 != null) {
      try
      {
        this.c = Long.parseLong(str6);
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
        this.d = Long.parseLong(str5);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemImage
 * JD-Core Version:    0.7.0.1
 */