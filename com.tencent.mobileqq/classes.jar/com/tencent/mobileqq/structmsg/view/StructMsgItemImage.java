package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView.ScaleType;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpic.HotPicHelper;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import com.tencent.mobileqq.transfile.AbsDownloader;
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
  public long c;
  public long d;
  public long e;
  public String u;
  public String v;
  public String w;
  
  public StructMsgItemImage()
  {
    this.jdField_a_of_type_JavaLangString = "image";
  }
  
  public StructMsgItemImage(String paramString)
  {
    this();
    this.u = paramString;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)
    {
      paramBundle = URLDrawableHelper.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, 65537);
      if ((this.jdField_a_of_type_JavaNetURL != null) && (this.jdField_a_of_type_JavaNetURL.equals(paramBundle))) {}
    }
    for (paramBundle = PicItemBuilder.a(paramContext, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic);; paramBundle = null)
    {
      Object localObject = paramBundle;
      MessageForPic localMessageForPic;
      if (paramBundle == null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, "StructMsgItemImage.createView.mImageShareMsg == null nudnik trick");
          }
          return new View(paramContext);
        }
        localMessageForPic = new MessageForPic();
        localMessageForPic.path = this.u;
        localMessageForPic.uuid = this.v;
        localMessageForPic.md5 = this.w;
        localMessageForPic.istroop = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.uinType;
        localMessageForPic.msgtype = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mMsgType;
        localMessageForPic.versionCode = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.messageVersion;
        localMessageForPic.uniseq = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mUniseq;
        localMessageForPic.issend = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mIsSend;
        localMessageForPic.selfuin = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.currentAccountUin;
        localMessageForPic.frienduin = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.uin;
        localMessageForPic.groupFileID = this.c;
        localMessageForPic.busiType = 1030;
        if (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mIsSend == 1)
        {
          paramBundle = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.currentAccountUin;
          localMessageForPic.senderuin = paramBundle;
          localMessageForPic.size = this.d;
          localMessageForPic.time = this.e;
          localMessageForPic.subVersion = 5;
          localMessageForPic.fileSizeFlag = 0;
          localMessageForPic.thumbHeight = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.thumbHeight;
          localMessageForPic.thumbWidth = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.thumbWidth;
          localMessageForPic.rawMsgUrl = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.rawUrl;
          localMessageForPic.bigMsgUrl = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.bigUrl;
          localMessageForPic.thumbMsgUrl = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.thumbUrl;
          paramBundle = AbsDownloader.a(URLDrawableHelper.a(localMessageForPic, 1, null).toString());
          if (paramBundle == null) {
            break label434;
          }
          if (GifDrawable.isGifFile(paramBundle)) {
            localMessageForPic.imageType = 2000;
          }
          label366:
          localObject = PicItemBuilder.a(paramContext, localMessageForPic);
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = localMessageForPic;
          this.jdField_a_of_type_JavaNetURL = ((URLDrawable)localObject).getURL();
        }
      }
      else
      {
        if ((paramView == null) || (!(paramView instanceof BubbleImageView))) {
          break label477;
        }
        paramContext = (BubbleImageView)paramView;
      }
      for (;;)
      {
        paramContext.d(false);
        paramContext.setShowEdge(true);
        paramContext.setImageDrawable((Drawable)localObject);
        return paramContext;
        paramBundle = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.uin;
        break;
        label434:
        if (!HotPicHelper.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.message)) {
          break label366;
        }
        localMessageForPic.imageType = 2000;
        localMessageForPic.saveExtInfoToExtStr("hot_pic_thumb_md5", this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.message.getExtInfoFromExtStr("hot_pic_thumb_md5"));
        break label366;
        label477:
        paramContext = new BubbleImageView(paramContext);
        paramContext.setId(2131361924);
        paramContext.setAdjustViewBounds(true);
        paramContext.setMaxWidth(URLDrawableHelper.a(false));
        paramContext.setMaxHeight(URLDrawableHelper.a(false));
        paramContext.setAdjustViewBounds(true);
        paramContext.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramContext.setRadius(12.0F);
      }
    }
  }
  
  public MessageForPic a()
  {
    MessageForPic localMessageForPic = new MessageForPic();
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, "StructMsgItemImage.generateMessageForPic.mImageShareMsg == null nudnik trick");
      }
      return localMessageForPic;
    }
    localMessageForPic.path = this.u;
    localMessageForPic.uuid = this.v;
    localMessageForPic.md5 = this.w;
    localMessageForPic.istroop = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.uinType;
    localMessageForPic.msgtype = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mMsgType;
    localMessageForPic.versionCode = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.messageVersion;
    localMessageForPic.uniseq = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mUniseq;
    localMessageForPic.issend = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mIsSend;
    localMessageForPic.selfuin = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.currentAccountUin;
    localMessageForPic.frienduin = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.uin;
    localMessageForPic.groupFileID = this.c;
    localMessageForPic.busiType = 1030;
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mIsSend == 1) {}
    for (String str = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.currentAccountUin;; str = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.uin)
    {
      localMessageForPic.senderuin = str;
      localMessageForPic.size = this.d;
      localMessageForPic.time = this.e;
      localMessageForPic.subVersion = 5;
      localMessageForPic.fileSizeFlag = 0;
      localMessageForPic.thumbHeight = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.thumbHeight;
      localMessageForPic.thumbWidth = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.thumbWidth;
      return localMessageForPic;
    }
  }
  
  public String a()
  {
    return "Image";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.u = paramObjectInput.readUTF();
    this.v = paramObjectInput.readUTF();
    this.w = paramObjectInput.readUTF();
    this.c = paramObjectInput.readLong();
    this.d = paramObjectInput.readLong();
    this.e = paramObjectInput.readLong();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.u == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.v != null) {
        break label98;
      }
      str = "";
      label34:
      paramObjectOutput.writeUTF(str);
      if (this.w != null) {
        break label106;
      }
    }
    label98:
    label106:
    for (String str = "";; str = this.w)
    {
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeLong(this.c);
      paramObjectOutput.writeLong(this.d);
      paramObjectOutput.writeLong(this.e);
      return;
      str = this.u;
      break;
      str = this.v;
      break label34;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "image");
    if (this.v == null)
    {
      str = "";
      paramXmlSerializer.attribute(null, "uuid", str);
      if (this.w != null) {
        break label134;
      }
      str = "";
      label44:
      paramXmlSerializer.attribute(null, "md5", str);
      paramXmlSerializer.attribute(null, "GroupFiledid", String.valueOf(this.c));
      paramXmlSerializer.attribute(null, "filesize", String.valueOf(this.d));
      if (this.u != null) {
        break label142;
      }
    }
    label134:
    label142:
    for (String str = "";; str = this.u)
    {
      paramXmlSerializer.attribute(null, "local_path", str);
      paramXmlSerializer.endTag(null, "image");
      return;
      str = this.v;
      break;
      str = this.w;
      break label44;
    }
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {}
    for (;;)
    {
      return true;
      String str3 = paramStructMsgNode.a("uuid");
      String str2 = paramStructMsgNode.a("md5");
      String str5 = paramStructMsgNode.a("md5");
      String str4 = paramStructMsgNode.a("filesize");
      String str1 = paramStructMsgNode.a("local_path");
      paramStructMsgNode = str3;
      if (str3 == null) {
        paramStructMsgNode = "";
      }
      this.v = paramStructMsgNode;
      if (str2 == null)
      {
        paramStructMsgNode = "";
        label74:
        this.w = paramStructMsgNode;
        if (str1 != null) {
          break label146;
        }
        paramStructMsgNode = "";
        this.u = paramStructMsgNode;
        if (str5 == null) {}
      }
      try
      {
        this.c = Long.parseLong(str5);
        if (str4 == null) {
          continue;
        }
        try
        {
          this.d = Long.parseLong(str4);
          return true;
        }
        catch (NumberFormatException paramStructMsgNode) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("StructMsg", 2, paramStructMsgNode.getMessage());
        return true;
        paramStructMsgNode = str2;
        break label74;
        label146:
        paramStructMsgNode = str1;
      }
      catch (NumberFormatException paramStructMsgNode)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, paramStructMsgNode.getMessage());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemImage
 * JD-Core Version:    0.7.0.1
 */