package cooperation.qqfav.globalsearch;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.base.presenter.SearchResultPresenter;
import com.tencent.mobileqq.search.base.view.ISearchResultView;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.qphone.base.util.QLog;

public class FavoriteSearchResultPresenter
  extends SearchResultPresenter
{
  private BitmapFactory.Options a = new BitmapFactory.Options();
  
  public FavoriteSearchResultPresenter(IFaceDecoder paramIFaceDecoder)
  {
    super(paramIFaceDecoder);
  }
  
  public void b(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    paramISearchResultView.a().setMaxWidth(800);
    FavoriteSearchResultModel localFavoriteSearchResultModel = (FavoriteSearchResultModel)paramISearchResultModel;
    ImageView localImageView = paramISearchResultView.b();
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    if ((5 != localFavoriteSearchResultModel.f) && (!localFavoriteSearchResultModel.jdField_a_of_type_Boolean))
    {
      localImageView.setImageDrawable(null);
      localImageView.setBackgroundDrawable(null);
    }
    else
    {
      localImageView.setImageResource(2130844218);
    }
    if (localFavoriteSearchResultModel.jdField_d_of_type_JavaLangString != null)
    {
      paramISearchResultModel = URLDrawable.URLDrawableOptions.obtain();
      paramISearchResultModel.mRequestHeight = paramISearchResultView.b().getHeight();
      paramISearchResultModel.mRequestWidth = paramISearchResultView.b().getWidth();
      if ((5 != localFavoriteSearchResultModel.f) && (!localFavoriteSearchResultModel.jdField_a_of_type_Boolean))
      {
        try
        {
          localImageView.setImageDrawable(URLDrawable.getDrawable(localFavoriteSearchResultModel.jdField_d_of_type_JavaLangString, paramISearchResultModel));
          return;
        }
        catch (Exception paramISearchResultModel)
        {
          if (!QLog.isColorLevel()) {
            break label373;
          }
        }
        paramISearchResultView = new StringBuilder();
        paramISearchResultView.append("bindFace exception = ");
        paramISearchResultView.append(paramISearchResultModel.toString());
        QLog.d("FavoriteSearchResultPresenter", 2, paramISearchResultView.toString());
      }
      else
      {
        localImageView.setBackgroundDrawable(URLDrawable.getDrawable(localFavoriteSearchResultModel.jdField_d_of_type_JavaLangString, paramISearchResultModel));
      }
    }
    else
    {
      if (localFavoriteSearchResultModel.jdField_d_of_type_Int != 0)
      {
        if ((5 != localFavoriteSearchResultModel.f) && (!localFavoriteSearchResultModel.jdField_a_of_type_Boolean))
        {
          localImageView.setImageResource(localFavoriteSearchResultModel.jdField_d_of_type_Int);
          return;
        }
        localImageView.setBackgroundResource(localFavoriteSearchResultModel.jdField_d_of_type_Int);
        return;
      }
      if (localFavoriteSearchResultModel.jdField_a_of_type_ArrayOfByte != null)
      {
        this.a.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(localFavoriteSearchResultModel.jdField_a_of_type_ArrayOfByte, 0, localFavoriteSearchResultModel.jdField_a_of_type_ArrayOfByte.length, this.a);
        paramISearchResultModel = this.a;
        paramISearchResultModel.inJustDecodeBounds = false;
        paramISearchResultModel.inSampleSize = (paramISearchResultModel.outWidth / paramISearchResultView.b().getMeasuredWidth());
      }
    }
    try
    {
      paramISearchResultModel = new BitmapDrawable(null, BitmapFactory.decodeByteArray(localFavoriteSearchResultModel.jdField_a_of_type_ArrayOfByte, 0, localFavoriteSearchResultModel.jdField_a_of_type_ArrayOfByte.length, this.a));
    }
    catch (OutOfMemoryError paramISearchResultModel)
    {
      label333:
      label373:
      break label333;
    }
    paramISearchResultModel = null;
    if ((5 != localFavoriteSearchResultModel.f) && (!localFavoriteSearchResultModel.jdField_a_of_type_Boolean))
    {
      localImageView.setImageDrawable(paramISearchResultModel);
      return;
    }
    localImageView.setBackgroundDrawable(paramISearchResultModel);
    return;
    super.b(paramISearchResultModel, paramISearchResultView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqfav.globalsearch.FavoriteSearchResultPresenter
 * JD-Core Version:    0.7.0.1
 */