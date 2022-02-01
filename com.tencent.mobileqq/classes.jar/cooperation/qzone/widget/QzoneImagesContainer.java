package cooperation.qzone.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.URLUtil;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.Iterator;
import java.util.List;

public class QzoneImagesContainer
  extends LinearLayout
{
  private static int MAX_NUM_CHILDREN = 5;
  private List<ByteStringMicro> images;
  private int totalPic;
  
  public QzoneImagesContainer(Context paramContext)
  {
    super(paramContext);
  }
  
  public QzoneImagesContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void setImagesInLayout(List<ByteStringMicro> paramList, int paramInt)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      removeAllViewsInLayout();
      paramList = paramList.iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        Object localObject1 = ((ByteStringMicro)paramList.next()).toStringUtf8();
        if (URLUtil.isValidUrl((String)localObject1))
        {
          int j = i + 1;
          int k = MAX_NUM_CHILDREN;
          Object localObject2;
          if (j < k)
          {
            localObject2 = new URLImageView(getContext());
            ((URLImageView)localObject2).setVisibility(0);
            ((URLImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
            ((URLImageView)localObject2).setImageURL((String)localObject1);
            localObject1 = new LinearLayout.LayoutParams(ViewUtils.b(60.0F), ViewUtils.b(60.0F));
            ((LinearLayout.LayoutParams)localObject1).setMargins(0, 0, ViewUtils.b(2.0F), 0);
            addViewInLayout((View)localObject2, j - 1, (ViewGroup.LayoutParams)localObject1);
            ((URLImageView)localObject2).setDuplicateParentStateEnabled(true);
            i = j;
          }
          else
          {
            i = j;
            if (j == k)
            {
              localObject2 = new MaskURLImageView(getContext());
              ((MaskURLImageView)localObject2).setVisibility(0);
              ((MaskURLImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
              ((MaskURLImageView)localObject2).setImageURL((String)localObject1);
              addViewInLayout((View)localObject2, j - 1, new LinearLayout.LayoutParams(ViewUtils.b(60.0F), ViewUtils.b(60.0F)));
              ((MaskURLImageView)localObject2).setHasMore(paramInt - j);
              ((MaskURLImageView)localObject2).setDuplicateParentStateEnabled(true);
              i = j;
            }
          }
        }
      }
      if (i > 0) {
        setVisibility(0);
      }
      return;
    }
    setVisibility(8);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt2 = getChildCount();
    paramInt1 = paramInt2;
    while ((paramInt1 > 0) && (getChildAt(paramInt1 - 1).getRight() > paramInt3)) {
      paramInt1 -= 1;
    }
    if (paramInt1 != paramInt2)
    {
      MAX_NUM_CHILDREN = paramInt1;
      this.images = this.images.subList(0, paramInt1);
      setImagesInLayout(this.images, this.totalPic);
      requestLayout();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setImages(List<ByteStringMicro> paramList, int paramInt, boolean paramBoolean)
  {
    this.images = paramList;
    this.totalPic = paramInt;
    removeAllViews();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Object localObject1;
      if (paramBoolean)
      {
        paramList = ((ByteStringMicro)paramList.get(0)).toStringUtf8();
        localObject1 = new MaskURLImageView(getContext());
        ((MaskURLImageView)localObject1).setVisibility(0);
        ((MaskURLImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_CROP);
        ((MaskURLImageView)localObject1).setImageURL(paramList);
        addView((View)localObject1, new LinearLayout.LayoutParams(ViewUtils.b(60.0F), ViewUtils.b(60.0F)));
        ((MaskURLImageView)localObject1).setNeedSowPlayIcon(true);
        ((MaskURLImageView)localObject1).setDuplicateParentStateEnabled(true);
        return;
      }
      paramList = paramList.iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        localObject1 = ((ByteStringMicro)paramList.next()).toStringUtf8();
        int k = ViewUtils.b(60.0F);
        if (URLUtil.isValidUrl((String)localObject1))
        {
          int j = i + 1;
          int m = MAX_NUM_CHILDREN;
          Object localObject2;
          URLDrawable.URLDrawableOptions localURLDrawableOptions;
          if (j < m)
          {
            localObject2 = new URLImageView(getContext());
            ((URLImageView)localObject2).setVisibility(0);
            ((URLImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
            localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
            localURLDrawableOptions.mRequestHeight = k;
            localURLDrawableOptions.mRequestWidth = k;
            ((URLImageView)localObject2).setImageDrawable(URLDrawable.getDrawable((String)localObject1, localURLDrawableOptions));
            localObject1 = new LinearLayout.LayoutParams(k, k);
            ((LinearLayout.LayoutParams)localObject1).setMargins(0, 0, ViewUtils.b(2.0F), 0);
            addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
            ((URLImageView)localObject2).setDuplicateParentStateEnabled(true);
            i = j;
          }
          else
          {
            i = j;
            if (j == m)
            {
              localObject2 = new MaskURLImageView(getContext());
              ((MaskURLImageView)localObject2).setVisibility(0);
              ((MaskURLImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
              localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
              localURLDrawableOptions.mRequestHeight = k;
              localURLDrawableOptions.mRequestWidth = k;
              ((MaskURLImageView)localObject2).setImageDrawable(URLDrawable.getDrawable((String)localObject1, localURLDrawableOptions));
              addView((View)localObject2, new LinearLayout.LayoutParams(k, k));
              ((MaskURLImageView)localObject2).setHasMore(paramInt - j);
              ((MaskURLImageView)localObject2).setDuplicateParentStateEnabled(true);
              i = j;
            }
          }
        }
      }
      if (i > 0) {
        setVisibility(0);
      }
      return;
    }
    setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.widget.QzoneImagesContainer
 * JD-Core Version:    0.7.0.1
 */