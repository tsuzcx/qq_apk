package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;

public class ComponentContentSmallGallery
  extends ComponentContentSmall
{
  TextView d;
  
  public ComponentContentSmallGallery(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentContentSmallGallery(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentContentSmallGallery(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.d = ((TextView)paramView.findViewById(2131433937));
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    if ((paramObject instanceof IReadInJoyModel))
    {
      paramObject = ((IReadInJoyModel)paramObject).k();
      this.d.setText(String.valueOf(paramObject.mGalleryPicNumber));
    }
  }
  
  public View b(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131626180, this, true);
  }
  
  public void b()
  {
    super.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentSmallGallery
 * JD-Core Version:    0.7.0.1
 */