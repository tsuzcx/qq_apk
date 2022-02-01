package cooperation.qzone.panorama.widget;

import android.content.Context;
import android.util.AttributeSet;
import bmbh;
import bmbi;
import bmbj;
import bmbk;
import bmbl;
import bmbm;
import bmbn;
import bmbx;
import bmcd;
import bmce;
import com.tencent.mobileqq.apollo.GLTextureView;

public class PanoramaView
  extends GLTextureView
{
  private Context jdField_a_of_type_AndroidContentContext;
  private bmbh jdField_a_of_type_Bmbh;
  private bmbj jdField_a_of_type_Bmbj = new bmcd(this);
  private bmbk jdField_a_of_type_Bmbk;
  private bmbl jdField_a_of_type_Bmbl = new bmce(this);
  private bmbm jdField_a_of_type_Bmbm;
  private bmbx jdField_a_of_type_Bmbx;
  
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
    if (this.jdField_a_of_type_Bmbm != null)
    {
      super.onPause();
      if (this.jdField_a_of_type_Bmbk != null) {
        this.jdField_a_of_type_Bmbk.b();
      }
      if (this.jdField_a_of_type_Bmbm != null) {
        this.jdField_a_of_type_Bmbm.a();
      }
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_Bmbm != null) {
      this.jdField_a_of_type_Bmbm.a(paramFloat1, paramFloat2);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bmbx == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_Bmbx.b(paramInt);
      setRenderMode(paramInt);
      if (paramInt == 0) {
        this.jdField_a_of_type_Bmbx.a(false);
      }
      while ((this.jdField_a_of_type_Bmbk != null) && (this.jdField_a_of_type_Bmbx.a()))
      {
        this.jdField_a_of_type_Bmbk.a();
        return;
        this.jdField_a_of_type_Bmbx.a(true);
      }
    }
  }
  
  public void a(bmbx parambmbx, bmbi parambmbi)
  {
    if (parambmbx == null) {
      return;
    }
    this.jdField_a_of_type_Bmbx = parambmbx;
    setEGLContextClientVersion(2);
    this.jdField_a_of_type_Bmbm = new bmbm(parambmbx, parambmbi);
    setRenderer(this.jdField_a_of_type_Bmbm);
    setRenderMode(parambmbx.c());
    if (parambmbx.b()) {
      setOnTouchListener(new bmbn(this, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bmbj, parambmbx));
    }
    this.jdField_a_of_type_Bmbk = new bmbk(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bmbl);
  }
  
  public String getRenderThreadName()
  {
    return "PanoramaViewThread";
  }
  
  public void onPause()
  {
    if ((this.jdField_a_of_type_Bmbm != null) && (this.jdField_a_of_type_Bmbx != null))
    {
      super.onPause();
      if ((this.jdField_a_of_type_Bmbk != null) && (this.jdField_a_of_type_Bmbx.a())) {
        this.jdField_a_of_type_Bmbk.b();
      }
    }
  }
  
  public void onResume()
  {
    if ((this.jdField_a_of_type_Bmbm != null) && (this.jdField_a_of_type_Bmbx != null))
    {
      this.jdField_a_of_type_Bmbx.a(true);
      super.onResume();
      if ((this.jdField_a_of_type_Bmbk != null) && (this.jdField_a_of_type_Bmbx.a())) {
        this.jdField_a_of_type_Bmbk.a();
      }
    }
  }
  
  public void setOnPanoramaClickListener(bmbh parambmbh)
  {
    this.jdField_a_of_type_Bmbh = parambmbh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.panorama.widget.PanoramaView
 * JD-Core Version:    0.7.0.1
 */