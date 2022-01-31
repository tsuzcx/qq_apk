import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.pubaccount.util.GalleryShareHelper;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import java.io.IOException;

public class muk
  extends AsyncTask
{
  public muk(GalleryShareHelper paramGalleryShareHelper, URLDrawable paramURLDrawable, String paramString) {}
  
  protected String a(Void... paramVarArgs)
  {
    try
    {
      paramVarArgs = this.jdField_a_of_type_ComTencentImageURLDrawable.saveTo(this.jdField_a_of_type_JavaLangString);
      if (paramVarArgs != null)
      {
        ImageUtil.a(GalleryShareHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilGalleryShareHelper), paramVarArgs);
        if (GalleryShareHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilGalleryShareHelper).getIntent().getBooleanExtra("from_photo_wall", false)) {
          return "已保存到手机相册";
        }
        return GalleryShareHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilGalleryShareHelper).getString(2131434582) + " " + paramVarArgs;
      }
      paramVarArgs = GalleryShareHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilGalleryShareHelper).getString(2131434583);
      return paramVarArgs;
    }
    catch (IOException paramVarArgs)
    {
      return GalleryShareHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilGalleryShareHelper).getString(2131434583);
    }
    catch (OutOfMemoryError paramVarArgs) {}
    return GalleryShareHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilGalleryShareHelper).getString(2131434583);
  }
  
  protected void a(String paramString)
  {
    QQToast.a(GalleryShareHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilGalleryShareHelper), paramString, 0).b(GalleryShareHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilGalleryShareHelper).getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     muk
 * JD-Core Version:    0.7.0.1
 */