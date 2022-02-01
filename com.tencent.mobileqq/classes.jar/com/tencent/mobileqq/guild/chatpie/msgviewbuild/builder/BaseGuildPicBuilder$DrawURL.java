package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

public class BaseGuildPicBuilder$DrawURL
{
  public URL a;
  public boolean b;
  public boolean c;
  
  public BaseGuildPicBuilder$DrawURL(MessageForPic paramMessageForPic)
  {
    paramMessageForPic.checkType();
    Object localObject;
    if ((paramMessageForPic.imageType == 3) || (paramMessageForPic.imageType == 2000))
    {
      this.b = true;
      localObject = URLDrawableHelper.getURL(paramMessageForPic, 1, null);
      if (AbsDownloader.getFile(((URL)localObject).toString()) != null)
      {
        this.a = ((URL)localObject);
        this.c = true;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getThumbDrawable,using GIF_BIG,uniseq:");
          ((StringBuilder)localObject).append(paramMessageForPic.uniseq);
          ((StringBuilder)localObject).append(" url:");
          ((StringBuilder)localObject).append(this.a);
          QLog.d("BaseGuildPicBuilder", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
    if (this.a == null)
    {
      this.a = URLDrawableHelper.getURL(paramMessageForPic, 65537, null);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getThumbDrawable,using thumb,uniseq:");
        ((StringBuilder)localObject).append(paramMessageForPic.uniseq);
        ((StringBuilder)localObject).append(" url:");
        ((StringBuilder)localObject).append(this.a);
        QLog.d("BaseGuildPicBuilder", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  @NonNull
  public String toString()
  {
    URL localURL = this.a;
    if (localURL != null) {
      return localURL.toString();
    }
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.BaseGuildPicBuilder.DrawURL
 * JD-Core Version:    0.7.0.1
 */