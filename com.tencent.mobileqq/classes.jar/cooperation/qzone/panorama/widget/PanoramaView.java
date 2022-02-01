package cooperation.qzone.panorama.widget;

import android.content.Context;
import android.util.AttributeSet;
import bncj;
import bnck;
import bncl;
import bncm;
import bncn;
import bnco;
import bncp;
import bncz;
import bndf;
import bndg;
import com.tencent.mobileqq.apollo.GLTextureView;

public class PanoramaView
  extends GLTextureView
{
  private Context jdField_a_of_type_AndroidContentContext;
  private bncj jdField_a_of_type_Bncj;
  private bncl jdField_a_of_type_Bncl = new bndf(this);
  private bncm jdField_a_of_type_Bncm;
  private bncn jdField_a_of_type_Bncn = new bndg(this);
  private bnco jdField_a_of_type_Bnco;
  private bncz jdField_a_of_type_Bncz;
  
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
    if (this.jdField_a_of_type_Bnco != null)
    {
      super.onPause();
      if (this.jdField_a_of_type_Bncm != null) {
        this.jdField_a_of_type_Bncm.b();
      }
      if (this.jdField_a_of_type_Bnco != null) {
        this.jdField_a_of_type_Bnco.a();
      }
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_Bnco != null) {
      this.jdField_a_of_type_Bnco.a(paramFloat1, paramFloat2);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bncz == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_Bncz.b(paramInt);
      setRenderMode(paramInt);
      if (paramInt == 0) {
        this.jdField_a_of_type_Bncz.a(false);
      }
      while ((this.jdField_a_of_type_Bncm != null) && (this.jdField_a_of_type_Bncz.a()))
      {
        this.jdField_a_of_type_Bncm.a();
        return;
        this.jdField_a_of_type_Bncz.a(true);
      }
    }
  }
  
  public void a(bncz parambncz, bnck parambnck)
  {
    if (parambncz == null) {
      return;
    }
    this.jdField_a_of_type_Bncz = parambncz;
    setEGLContextClientVersion(2);
    this.jdField_a_of_type_Bnco = new bnco(parambncz, parambnck);
    setRenderer(this.jdField_a_of_type_Bnco);
    setRenderMode(parambncz.c());
    if (parambncz.b()) {
      setOnTouchListener(new bncp(this, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bncl, parambncz));
    }
    this.jdField_a_of_type_Bncm = new bncm(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bncn);
  }
  
  public String getRenderThreadName()
  {
    return "PanoramaViewThread";
  }
  
  public void onPause()
  {
    if ((this.jdField_a_of_type_Bnco != null) && (this.jdField_a_of_type_Bncz != null))
    {
      super.onPause();
      if ((this.jdField_a_of_type_Bncm != null) && (this.jdField_a_of_type_Bncz.a())) {
        this.jdField_a_of_type_Bncm.b();
      }
    }
  }
  
  public void onResume()
  {
    if ((this.jdField_a_of_type_Bnco != null) && (this.jdField_a_of_type_Bncz != null))
    {
      this.jdField_a_of_type_Bncz.a(true);
      super.onResume();
      if ((this.jdField_a_of_type_Bncm != null) && (this.jdField_a_of_type_Bncz.a())) {
        this.jdField_a_of_type_Bncm.a();
      }
    }
  }
  
  public void setOnPanoramaClickListener(bncj parambncj)
  {
    this.jdField_a_of_type_Bncj = parambncj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.panorama.widget.PanoramaView
 * JD-Core Version:    0.7.0.1
 */