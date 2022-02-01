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
      paramVarArgs = this.jdField_a_of_type_ComTencentImageURLDrawable.saveTo(this.jdField_a_of_type_JavaLangString);
      if (paramVarArgs != null)
      {
        ImageUtil.a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityCardPicGalleryActivity, paramVarArgs);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityCardPicGalleryActivity.getString(2131694913));
        localStringBuilder.append(" ");
        localStringBuilder.append(paramVarArgs);
        return localStringBuilder.toString();
      }
      paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityCardPicGalleryActivity.getString(2131694911);
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
    return this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityCardPicGalleryActivity.getString(2131694911);
    return this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityCardPicGalleryActivity.getString(2131694911);
  }
  
  protected void a(String paramString)
  {
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityCardPicGalleryActivity, paramString, 0).b(this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityCardPicGalleryActivity.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.activity.CardPicGalleryActivity.9
 * JD-Core Version:    0.7.0.1
 */