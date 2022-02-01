package cooperation.qzone.widget;

import agej;
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
import java.util.Iterator;
import java.util.List;

public class QzoneImagesContainer
  extends LinearLayout
{
  private static int jdField_a_of_type_Int = 5;
  private List<ByteStringMicro> jdField_a_of_type_JavaUtilList;
  private int b;
  
  public QzoneImagesContainer(Context paramContext)
  {
    super(paramContext);
  }
  
  public QzoneImagesContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(List<ByteStringMicro> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      setVisibility(8);
      return;
    }
    removeAllViewsInLayout();
    paramList = paramList.iterator();
    int i = 0;
    label33:
    Object localObject1;
    int j;
    Object localObject2;
    if (paramList.hasNext())
    {
      localObject1 = ((ByteStringMicro)paramList.next()).toStringUtf8();
      if (!URLUtil.isValidUrl((String)localObject1)) {
        break label291;
      }
      j = i + 1;
      if (j < jdField_a_of_type_Int)
      {
        localObject2 = new URLImageView(getContext());
        ((URLImageView)localObject2).setVisibility(0);
        ((URLImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
        ((URLImageView)localObject2).setImageURL((String)localObject1);
        localObject1 = new LinearLayout.LayoutParams(agej.a(60.0F, getResources()), agej.a(60.0F, getResources()));
        ((LinearLayout.LayoutParams)localObject1).setMargins(0, 0, agej.a(2.0F, getResources()), 0);
        addViewInLayout((View)localObject2, j - 1, (ViewGroup.LayoutParams)localObject1);
        ((URLImageView)localObject2).setDuplicateParentStateEnabled(true);
        i = j;
      }
    }
    label291:
    for (;;)
    {
      break label33;
      i = j;
      if (j == jdField_a_of_type_Int)
      {
        localObject2 = new MaskURLImageView(getContext());
        ((MaskURLImageView)localObject2).setVisibility(0);
        ((MaskURLImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
        ((MaskURLImageView)localObject2).setImageURL((String)localObject1);
        addViewInLayout((View)localObject2, j - 1, new LinearLayout.LayoutParams(agej.a(60.0F, getResources()), agej.a(60.0F, getResources())));
        ((MaskURLImageView)localObject2).setHasMore(paramInt - j);
        ((MaskURLImageView)localObject2).setDuplicateParentStateEnabled(true);
        i = j;
        continue;
        if (i <= 0) {
          break;
        }
        setVisibility(0);
        return;
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt2 = getChildCount();
    paramInt1 = paramInt2;
    for (;;)
    {
      if ((paramInt1 <= 0) || (getChildAt(paramInt1 - 1).getRight() <= paramInt3))
      {
        if (paramInt1 != paramInt2)
        {
          jdField_a_of_type_Int = paramInt1;
          this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList.subList(0, paramInt1);
          a(this.jdField_a_of_type_JavaUtilList, this.b);
          requestLayout();
        }
        return;
      }
      paramInt1 -= 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setImages(List<ByteStringMicro> paramList, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.b = paramInt;
    removeAllViews();
    if ((paramList == null) || (paramList.isEmpty()))
    {
      setVisibility(8);
      return;
    }
    Object localObject1;
    if (paramBoolean)
    {
      paramList = ((ByteStringMicro)paramList.get(0)).toStringUtf8();
      localObject1 = new MaskURLImageView(getContext());
      ((MaskURLImageView)localObject1).setVisibility(0);
      ((MaskURLImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_CROP);
      ((MaskURLImageView)localObject1).setImageURL(paramList);
      addView((View)localObject1, new LinearLayout.LayoutParams(agej.a(60.0F, getResources()), agej.a(60.0F, getResources())));
      ((MaskURLImageView)localObject1).setNeedSowPlayIcon(true);
      ((MaskURLImageView)localObject1).setDuplicateParentStateEnabled(true);
      return;
    }
    paramList = paramList.iterator();
    int i = 0;
    label139:
    int k;
    int j;
    Object localObject2;
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    if (paramList.hasNext())
    {
      localObject1 = ((ByteStringMicro)paramList.next()).toStringUtf8();
      k = agej.a(60.0F, getResources());
      if (!URLUtil.isValidUrl((String)localObject1)) {
        break label423;
      }
      j = i + 1;
      if (j < jdField_a_of_type_Int)
      {
        localObject2 = new URLImageView(getContext());
        ((URLImageView)localObject2).setVisibility(0);
        ((URLImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestHeight = k;
        localURLDrawableOptions.mRequestWidth = k;
        ((URLImageView)localObject2).setImageDrawable(URLDrawable.getDrawable((String)localObject1, localURLDrawableOptions));
        localObject1 = new LinearLayout.LayoutParams(k, k);
        ((LinearLayout.LayoutParams)localObject1).setMargins(0, 0, agej.a(2.0F, getResources()), 0);
        addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
        ((URLImageView)localObject2).setDuplicateParentStateEnabled(true);
        i = j;
      }
    }
    label423:
    for (;;)
    {
      break label139;
      i = j;
      if (j == jdField_a_of_type_Int)
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
        continue;
        if (i <= 0) {
          break;
        }
        setVisibility(0);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.widget.QzoneImagesContainer
 * JD-Core Version:    0.7.0.1
 */