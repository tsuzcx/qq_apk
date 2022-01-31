package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import biqh;
import biqi;
import java.util.ArrayList;
import java.util.List;

public class FaceViewPager
  extends ViewPager
{
  private List<biqi> a;
  
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
    setOnPageChangeListener(new biqh(this));
  }
  
  public void a(biqi parambiqi)
  {
    if (!this.a.contains(parambiqi)) {
      this.a.add(parambiqi);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.FaceViewPager
 * JD-Core Version:    0.7.0.1
 */