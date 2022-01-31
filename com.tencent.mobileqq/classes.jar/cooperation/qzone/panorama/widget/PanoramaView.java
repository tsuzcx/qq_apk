package cooperation.qzone.panorama.widget;

import android.content.Context;
import android.util.AttributeSet;
import bhgp;
import bhgq;
import bhgr;
import bhgs;
import bhgt;
import bhgu;
import bhgv;
import bhhf;
import bhhl;
import bhhm;
import com.tencent.mobileqq.apollo.GLTextureView;

public class PanoramaView
  extends GLTextureView
{
  private Context jdField_a_of_type_AndroidContentContext;
  private bhgp jdField_a_of_type_Bhgp;
  private bhgr jdField_a_of_type_Bhgr = new bhhl(this);
  private bhgs jdField_a_of_type_Bhgs;
  private bhgt jdField_a_of_type_Bhgt = new bhhm(this);
  private bhgu jdField_a_of_type_Bhgu;
  private bhhf jdField_a_of_type_Bhhf;
  
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
    if (this.jdField_a_of_type_Bhgu != null)
    {
      super.onPause();
      if (this.jdField_a_of_type_Bhgs != null) {
        this.jdField_a_of_type_Bhgs.b();
      }
      if (this.jdField_a_of_type_Bhgu != null) {
        this.jdField_a_of_type_Bhgu.a();
      }
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_Bhgu != null) {
      this.jdField_a_of_type_Bhgu.a(paramFloat1, paramFloat2);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bhhf == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_Bhhf.b(paramInt);
      setRenderMode(paramInt);
      if (paramInt == 0) {
        this.jdField_a_of_type_Bhhf.a(false);
      }
      while ((this.jdField_a_of_type_Bhgs != null) && (this.jdField_a_of_type_Bhhf.a()))
      {
        this.jdField_a_of_type_Bhgs.a();
        return;
        this.jdField_a_of_type_Bhhf.a(true);
      }
    }
  }
  
  public void a(bhhf parambhhf, bhgq parambhgq)
  {
    if (parambhhf == null) {
      return;
    }
    this.jdField_a_of_type_Bhhf = parambhhf;
    setEGLContextClientVersion(2);
    this.jdField_a_of_type_Bhgu = new bhgu(parambhhf, parambhgq);
    setRenderer(this.jdField_a_of_type_Bhgu);
    setRenderMode(parambhhf.c());
    if (parambhhf.b()) {
      setOnTouchListener(new bhgv(this, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bhgr, parambhhf));
    }
    this.jdField_a_of_type_Bhgs = new bhgs(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bhgt);
  }
  
  public String getRenderThreadName()
  {
    return "PanoramaViewThread";
  }
  
  public void onPause()
  {
    if ((this.jdField_a_of_type_Bhgu != null) && (this.jdField_a_of_type_Bhhf != null))
    {
      super.onPause();
      if ((this.jdField_a_of_type_Bhgs != null) && (this.jdField_a_of_type_Bhhf.a())) {
        this.jdField_a_of_type_Bhgs.b();
      }
    }
  }
  
  public void onResume()
  {
    if ((this.jdField_a_of_type_Bhgu != null) && (this.jdField_a_of_type_Bhhf != null))
    {
      this.jdField_a_of_type_Bhhf.a(true);
      super.onResume();
      if ((this.jdField_a_of_type_Bhgs != null) && (this.jdField_a_of_type_Bhhf.a())) {
        this.jdField_a_of_type_Bhgs.a();
      }
    }
  }
  
  public void setOnPanoramaClickListener(bhgp parambhgp)
  {
    this.jdField_a_of_type_Bhgp = parambhgp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.panorama.widget.PanoramaView
 * JD-Core Version:    0.7.0.1
 */