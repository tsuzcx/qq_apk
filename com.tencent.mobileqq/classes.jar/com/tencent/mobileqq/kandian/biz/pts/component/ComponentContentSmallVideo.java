package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.pts.UtilsForComponent;

public class ComponentContentSmallVideo
  extends ComponentContentSmall
{
  TextView d;
  
  public ComponentContentSmallVideo(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentContentSmallVideo(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentContentSmallVideo(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.d = ((TextView)paramView.findViewById(2131432267));
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    if ((paramObject instanceof IReadInJoyModel))
    {
      paramObject = ((IReadInJoyModel)paramObject).k();
      if (paramObject == null) {
        return;
      }
      this.d.setText(UtilsForComponent.a(paramObject.mVideoDuration));
    }
  }
  
  public View b(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131626181, this, true);
  }
  
  public void b()
  {
    super.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentSmallVideo
 * JD-Core Version:    0.7.0.1
 */