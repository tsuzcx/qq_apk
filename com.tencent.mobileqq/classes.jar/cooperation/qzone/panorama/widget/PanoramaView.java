package cooperation.qzone.panorama.widget;

import android.content.Context;
import android.util.AttributeSet;
import bhhg;
import bhhh;
import bhhi;
import bhhj;
import bhhk;
import bhhl;
import bhhm;
import bhhw;
import bhic;
import bhid;
import com.tencent.mobileqq.apollo.GLTextureView;

public class PanoramaView
  extends GLTextureView
{
  private Context jdField_a_of_type_AndroidContentContext;
  private bhhg jdField_a_of_type_Bhhg;
  private bhhi jdField_a_of_type_Bhhi = new bhic(this);
  private bhhj jdField_a_of_type_Bhhj;
  private bhhk jdField_a_of_type_Bhhk = new bhid(this);
  private bhhl jdField_a_of_type_Bhhl;
  private bhhw jdField_a_of_type_Bhhw;
  
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
    if (this.jdField_a_of_type_Bhhl != null)
    {
      super.onPause();
      if (this.jdField_a_of_type_Bhhj != null) {
        this.jdField_a_of_type_Bhhj.b();
      }
      if (this.jdField_a_of_type_Bhhl != null) {
        this.jdField_a_of_type_Bhhl.a();
      }
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_Bhhl != null) {
      this.jdField_a_of_type_Bhhl.a(paramFloat1, paramFloat2);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bhhw == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_Bhhw.b(paramInt);
      setRenderMode(paramInt);
      if (paramInt == 0) {
        this.jdField_a_of_type_Bhhw.a(false);
      }
      while ((this.jdField_a_of_type_Bhhj != null) && (this.jdField_a_of_type_Bhhw.a()))
      {
        this.jdField_a_of_type_Bhhj.a();
        return;
        this.jdField_a_of_type_Bhhw.a(true);
      }
    }
  }
  
  public void a(bhhw parambhhw, bhhh parambhhh)
  {
    if (parambhhw == null) {
      return;
    }
    this.jdField_a_of_type_Bhhw = parambhhw;
    setEGLContextClientVersion(2);
    this.jdField_a_of_type_Bhhl = new bhhl(parambhhw, parambhhh);
    setRenderer(this.jdField_a_of_type_Bhhl);
    setRenderMode(parambhhw.c());
    if (parambhhw.b()) {
      setOnTouchListener(new bhhm(this, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bhhi, parambhhw));
    }
    this.jdField_a_of_type_Bhhj = new bhhj(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bhhk);
  }
  
  public String getRenderThreadName()
  {
    return "PanoramaViewThread";
  }
  
  public void onPause()
  {
    if ((this.jdField_a_of_type_Bhhl != null) && (this.jdField_a_of_type_Bhhw != null))
    {
      super.onPause();
      if ((this.jdField_a_of_type_Bhhj != null) && (this.jdField_a_of_type_Bhhw.a())) {
        this.jdField_a_of_type_Bhhj.b();
      }
    }
  }
  
  public void onResume()
  {
    if ((this.jdField_a_of_type_Bhhl != null) && (this.jdField_a_of_type_Bhhw != null))
    {
      this.jdField_a_of_type_Bhhw.a(true);
      super.onResume();
      if ((this.jdField_a_of_type_Bhhj != null) && (this.jdField_a_of_type_Bhhw.a())) {
        this.jdField_a_of_type_Bhhj.a();
      }
    }
  }
  
  public void setOnPanoramaClickListener(bhhg parambhhg)
  {
    this.jdField_a_of_type_Bhhg = parambhhg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.panorama.widget.PanoramaView
 * JD-Core Version:    0.7.0.1
 */