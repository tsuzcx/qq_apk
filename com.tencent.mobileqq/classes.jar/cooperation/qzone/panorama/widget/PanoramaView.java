package cooperation.qzone.panorama.widget;

import android.content.Context;
import android.util.AttributeSet;
import bjmy;
import bjmz;
import bjna;
import bjnb;
import bjnc;
import bjnd;
import bjne;
import bjno;
import bjnu;
import bjnv;
import com.tencent.mobileqq.apollo.GLTextureView;

public class PanoramaView
  extends GLTextureView
{
  private Context jdField_a_of_type_AndroidContentContext;
  private bjmy jdField_a_of_type_Bjmy;
  private bjna jdField_a_of_type_Bjna = new bjnu(this);
  private bjnb jdField_a_of_type_Bjnb;
  private bjnc jdField_a_of_type_Bjnc = new bjnv(this);
  private bjnd jdField_a_of_type_Bjnd;
  private bjno jdField_a_of_type_Bjno;
  
  public PanoramaView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public PanoramaView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bjnd != null)
    {
      super.onPause();
      if (this.jdField_a_of_type_Bjnb != null) {
        this.jdField_a_of_type_Bjnb.b();
      }
      if (this.jdField_a_of_type_Bjnd != null) {
        this.jdField_a_of_type_Bjnd.a();
      }
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_Bjnd != null) {
      this.jdField_a_of_type_Bjnd.a(paramFloat1, paramFloat2);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bjno == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_Bjno.b(paramInt);
      setRenderMode(paramInt);
      if (paramInt == 0) {
        this.jdField_a_of_type_Bjno.a(false);
      }
      while ((this.jdField_a_of_type_Bjnb != null) && (this.jdField_a_of_type_Bjno.a()))
      {
        this.jdField_a_of_type_Bjnb.a();
        return;
        this.jdField_a_of_type_Bjno.a(true);
      }
    }
  }
  
  public void a(bjno parambjno, bjmz parambjmz)
  {
    if (parambjno == null) {
      return;
    }
    this.jdField_a_of_type_Bjno = parambjno;
    setEGLContextClientVersion(2);
    this.jdField_a_of_type_Bjnd = new bjnd(parambjno, parambjmz);
    setRenderer(this.jdField_a_of_type_Bjnd);
    setRenderMode(parambjno.c());
    if (parambjno.b()) {
      setOnTouchListener(new bjne(this, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bjna, parambjno));
    }
    this.jdField_a_of_type_Bjnb = new bjnb(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bjnc);
  }
  
  public String getRenderThreadName()
  {
    return "PanoramaViewThread";
  }
  
  public void onPause()
  {
    if ((this.jdField_a_of_type_Bjnd != null) && (this.jdField_a_of_type_Bjno != null))
    {
      super.onPause();
      if ((this.jdField_a_of_type_Bjnb != null) && (this.jdField_a_of_type_Bjno.a())) {
        this.jdField_a_of_type_Bjnb.b();
      }
    }
  }
  
  public void onResume()
  {
    if ((this.jdField_a_of_type_Bjnd != null) && (this.jdField_a_of_type_Bjno != null))
    {
      this.jdField_a_of_type_Bjno.a(true);
      super.onResume();
      if ((this.jdField_a_of_type_Bjnb != null) && (this.jdField_a_of_type_Bjno.a())) {
        this.jdField_a_of_type_Bjnb.a();
      }
    }
  }
  
  public void setOnPanoramaClickListener(bjmy parambjmy)
  {
    this.jdField_a_of_type_Bjmy = parambjmy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.panorama.widget.PanoramaView
 * JD-Core Version:    0.7.0.1
 */