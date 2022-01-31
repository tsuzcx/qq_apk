package cooperation.qzone.panorama.widget;

import android.content.Context;
import android.util.AttributeSet;
import bjir;
import bjis;
import bjit;
import bjiu;
import bjiv;
import bjiw;
import bjix;
import bjjh;
import bjjn;
import bjjo;
import com.tencent.mobileqq.apollo.GLTextureView;

public class PanoramaView
  extends GLTextureView
{
  private Context jdField_a_of_type_AndroidContentContext;
  private bjir jdField_a_of_type_Bjir;
  private bjit jdField_a_of_type_Bjit = new bjjn(this);
  private bjiu jdField_a_of_type_Bjiu;
  private bjiv jdField_a_of_type_Bjiv = new bjjo(this);
  private bjiw jdField_a_of_type_Bjiw;
  private bjjh jdField_a_of_type_Bjjh;
  
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
    if (this.jdField_a_of_type_Bjiw != null)
    {
      super.onPause();
      if (this.jdField_a_of_type_Bjiu != null) {
        this.jdField_a_of_type_Bjiu.b();
      }
      if (this.jdField_a_of_type_Bjiw != null) {
        this.jdField_a_of_type_Bjiw.a();
      }
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_Bjiw != null) {
      this.jdField_a_of_type_Bjiw.a(paramFloat1, paramFloat2);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bjjh == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_Bjjh.b(paramInt);
      setRenderMode(paramInt);
      if (paramInt == 0) {
        this.jdField_a_of_type_Bjjh.a(false);
      }
      while ((this.jdField_a_of_type_Bjiu != null) && (this.jdField_a_of_type_Bjjh.a()))
      {
        this.jdField_a_of_type_Bjiu.a();
        return;
        this.jdField_a_of_type_Bjjh.a(true);
      }
    }
  }
  
  public void a(bjjh parambjjh, bjis parambjis)
  {
    if (parambjjh == null) {
      return;
    }
    this.jdField_a_of_type_Bjjh = parambjjh;
    setEGLContextClientVersion(2);
    this.jdField_a_of_type_Bjiw = new bjiw(parambjjh, parambjis);
    setRenderer(this.jdField_a_of_type_Bjiw);
    setRenderMode(parambjjh.c());
    if (parambjjh.b()) {
      setOnTouchListener(new bjix(this, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bjit, parambjjh));
    }
    this.jdField_a_of_type_Bjiu = new bjiu(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bjiv);
  }
  
  public String getRenderThreadName()
  {
    return "PanoramaViewThread";
  }
  
  public void onPause()
  {
    if ((this.jdField_a_of_type_Bjiw != null) && (this.jdField_a_of_type_Bjjh != null))
    {
      super.onPause();
      if ((this.jdField_a_of_type_Bjiu != null) && (this.jdField_a_of_type_Bjjh.a())) {
        this.jdField_a_of_type_Bjiu.b();
      }
    }
  }
  
  public void onResume()
  {
    if ((this.jdField_a_of_type_Bjiw != null) && (this.jdField_a_of_type_Bjjh != null))
    {
      this.jdField_a_of_type_Bjjh.a(true);
      super.onResume();
      if ((this.jdField_a_of_type_Bjiu != null) && (this.jdField_a_of_type_Bjjh.a())) {
        this.jdField_a_of_type_Bjiu.a();
      }
    }
  }
  
  public void setOnPanoramaClickListener(bjir parambjir)
  {
    this.jdField_a_of_type_Bjir = parambjir;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.panorama.widget.PanoramaView
 * JD-Core Version:    0.7.0.1
 */