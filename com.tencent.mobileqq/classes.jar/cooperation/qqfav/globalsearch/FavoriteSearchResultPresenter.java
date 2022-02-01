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
    paramISearchResultView.b().setMaxWidth(800);
    FavoriteSearchResultModel localFavoriteSearchResultModel = (FavoriteSearchResultModel)paramISearchResultModel;
    ImageView localImageView = paramISearchResultView.g();
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    if ((5 != localFavoriteSearchResultModel.n) && (!localFavoriteSearchResultModel.o))
    {
      localImageView.setImageDrawable(null);
      localImageView.setBackgroundDrawable(null);
    }
    else
    {
      localImageView.setImageResource(2130845535);
    }
    if (localFavoriteSearchResultModel.j != null)
    {
      paramISearchResultModel = URLDrawable.URLDrawableOptions.obtain();
      paramISearchResultModel.mRequestHeight = paramISearchResultView.g().getHeight();
      paramISearchResultModel.mRequestWidth = paramISearchResultView.g().getWidth();
      if ((5 != localFavoriteSearchResultModel.n) && (!localFavoriteSearchResultModel.o))
      {
        try
        {
          localImageView.setImageDrawable(URLDrawable.getDrawable(localFavoriteSearchResultModel.j, paramISearchResultModel));
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
        localImageView.setBackgroundDrawable(URLDrawable.getDrawable(localFavoriteSearchResultModel.j, paramISearchResultModel));
      }
    }
    else
    {
      if (localFavoriteSearchResultModel.k != 0)
      {
        if ((5 != localFavoriteSearchResultModel.n) && (!localFavoriteSearchResultModel.o))
        {
          localImageView.setImageResource(localFavoriteSearchResultModel.k);
          return;
        }
        localImageView.setBackgroundResource(localFavoriteSearchResultModel.k);
        return;
      }
      if (localFavoriteSearchResultModel.l != null)
      {
        this.a.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(localFavoriteSearchResultModel.l, 0, localFavoriteSearchResultModel.l.length, this.a);
        paramISearchResultModel = this.a;
        paramISearchResultModel.inJustDecodeBounds = false;
        paramISearchResultModel.inSampleSize = (paramISearchResultModel.outWidth / paramISearchResultView.g().getMeasuredWidth());
      }
    }
    try
    {
      paramISearchResultModel = new BitmapDrawable(null, BitmapFactory.decodeByteArray(localFavoriteSearchResultModel.l, 0, localFavoriteSearchResultModel.l.length, this.a));
    }
    catch (OutOfMemoryError paramISearchResultModel)
    {
      label333:
      label373:
      break label333;
    }
    paramISearchResultModel = null;
    if ((5 != localFavoriteSearchResultModel.n) && (!localFavoriteSearchResultModel.o))
    {
      localImageView.setImageDrawable(paramISearchResultModel);
      return;
    }
    localImageView.setBackgroundDrawable(paramISearchResultModel);
    return;
    super.b(paramISearchResultModel, paramISearchResultView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqfav.globalsearch.FavoriteSearchResultPresenter
 * JD-Core Version:    0.7.0.1
 */