package cooperation.qzone.panorama.widget;

import android.content.Context;
import android.util.AttributeSet;
import bfye;
import bfyf;
import bfyg;
import bfyh;
import bfyi;
import bfyj;
import bfyk;
import bfyu;
import bfza;
import bfzb;
import com.tencent.mobileqq.apollo.GLTextureView;

public class PanoramaView
  extends GLTextureView
{
  private Context jdField_a_of_type_AndroidContentContext;
  private bfye jdField_a_of_type_Bfye;
  private bfyg jdField_a_of_type_Bfyg = new bfza(this);
  private bfyh jdField_a_of_type_Bfyh;
  private bfyi jdField_a_of_type_Bfyi = new bfzb(this);
  private bfyj jdField_a_of_type_Bfyj;
  private bfyu jdField_a_of_type_Bfyu;
  
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
    if (this.jdField_a_of_type_Bfyj != null)
    {
      super.onPause();
      if (this.jdField_a_of_type_Bfyh != null) {
        this.jdField_a_of_type_Bfyh.b();
      }
      if (this.jdField_a_of_type_Bfyj != null) {
        this.jdField_a_of_type_Bfyj.a();
      }
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_Bfyj != null) {
      this.jdField_a_of_type_Bfyj.a(paramFloat1, paramFloat2);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bfyu == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_Bfyu.b(paramInt);
      setRenderMode(paramInt);
      if (paramInt == 0) {
        this.jdField_a_of_type_Bfyu.a(false);
      }
      while ((this.jdField_a_of_type_Bfyh != null) && (this.jdField_a_of_type_Bfyu.a()))
      {
        this.jdField_a_of_type_Bfyh.a();
        return;
        this.jdField_a_of_type_Bfyu.a(true);
      }
    }
  }
  
  public void a(bfyu parambfyu, bfyf parambfyf)
  {
    if (parambfyu == null) {
      return;
    }
    this.jdField_a_of_type_Bfyu = parambfyu;
    setEGLContextClientVersion(2);
    this.jdField_a_of_type_Bfyj = new bfyj(parambfyu, parambfyf);
    setRenderer(this.jdField_a_of_type_Bfyj);
    setRenderMode(parambfyu.c());
    if (parambfyu.b()) {
      setOnTouchListener(new bfyk(this, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bfyg, parambfyu));
    }
    this.jdField_a_of_type_Bfyh = new bfyh(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bfyi);
  }
  
  public String getRenderThreadName()
  {
    return "PanoramaViewThread";
  }
  
  public void onPause()
  {
    if ((this.jdField_a_of_type_Bfyj != null) && (this.jdField_a_of_type_Bfyu != null))
    {
      super.onPause();
      if ((this.jdField_a_of_type_Bfyh != null) && (this.jdField_a_of_type_Bfyu.a())) {
        this.jdField_a_of_type_Bfyh.b();
      }
    }
  }
  
  public void onResume()
  {
    if ((this.jdField_a_of_type_Bfyj != null) && (this.jdField_a_of_type_Bfyu != null))
    {
      this.jdField_a_of_type_Bfyu.a(true);
      super.onResume();
      if ((this.jdField_a_of_type_Bfyh != null) && (this.jdField_a_of_type_Bfyu.a())) {
        this.jdField_a_of_type_Bfyh.a();
      }
    }
  }
  
  public void setOnPanoramaClickListener(bfye parambfye)
  {
    this.jdField_a_of_type_Bfye = parambfye;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.panorama.widget.PanoramaView
 * JD-Core Version:    0.7.0.1
 */