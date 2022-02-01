package com.tencent.mobileqq.businessCard.activity;

import android.os.AsyncTask;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import java.io.IOException;

class CardPicGalleryActivity$9
  extends AsyncTask<Void, Void, String>
{
  CardPicGalleryActivity$9(CardPicGalleryActivity paramCardPicGalleryActivity, URLDrawable paramURLDrawable, String paramString) {}
  
  protected String a(Void... paramVarArgs)
  {
    try
    {
      paramVarArgs = this.a.saveTo(this.b);
      if (paramVarArgs != null)
      {
        ImageUtil.b(this.c, paramVarArgs);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.c.getString(2131892639));
        localStringBuilder.append(" ");
        localStringBuilder.append(paramVarArgs);
        return localStringBuilder.toString();
      }
      paramVarArgs = this.c.getString(2131892637);
      return paramVarArgs;
    }
    catch (IOException paramVarArgs)
    {
      break label86;
    }
    catch (OutOfMemoryError paramVarArgs)
    {
      label76:
      label86:
      break label76;
    }
    return this.c.getString(2131892637);
    return this.c.getString(2131892637);
  }
  
  protected void a(String paramString)
  {
    QQToast.makeText(this.c, paramString, 0).show(this.c.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.activity.CardPicGalleryActivity.9
 * JD-Core Version:    0.7.0.1
 */