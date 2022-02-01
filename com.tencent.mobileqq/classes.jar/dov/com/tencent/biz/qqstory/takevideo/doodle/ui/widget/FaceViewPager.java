package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import bpov;
import bpow;
import java.util.ArrayList;
import java.util.List;

public class FaceViewPager
  extends ViewPager
{
  private List<bpow> a;
  
  public FaceViewPager(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public FaceViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.a = new ArrayList();
    setOnPageChangeListener(new bpov(this));
  }
  
  public void a(bpow parambpow)
  {
    if (!this.a.contains(parambpow)) {
      this.a.add(parambpow);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.FaceViewPager
 * JD-Core Version:    0.7.0.1
 */