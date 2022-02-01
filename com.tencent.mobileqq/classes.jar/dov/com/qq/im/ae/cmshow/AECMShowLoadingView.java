package dov.com.qq.im.ae.cmshow;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bnip;
import bnrh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ttpic.openapi.initializer.PagInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import org.libpag.PAGFile;
import org.libpag.PAGView;

public class AECMShowLoadingView
  extends RelativeLayout
{
  private int jdField_a_of_type_Int = 1;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AECMShowSquareLayout jdField_a_of_type_DovComQqImAeCmshowAECMShowSquareLayout;
  private String jdField_a_of_type_JavaLangString;
  private PAGFile jdField_a_of_type_OrgLibpagPAGFile;
  private PAGView jdField_a_of_type_OrgLibpagPAGView;
  private boolean jdField_a_of_type_Boolean;
  private PAGFile b;
  
  public AECMShowLoadingView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AECMShowLoadingView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AECMShowLoadingView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
    a(paramContext);
  }
  
  private void a()
  {
    try
    {
      if (FeatureManager.Features.PAG.init())
      {
        this.jdField_a_of_type_OrgLibpagPAGFile = PAGFile.Load(BaseApplicationImpl.getApplication().getResources().getAssets(), "camera/cmshow/ae_camera_cmshow_loading_success.pag");
        this.b = PAGFile.Load(BaseApplicationImpl.getApplication().getResources().getAssets(), "camera/cmshow/ae_camera_cmshow_loading_fail.pag");
        this.jdField_a_of_type_Boolean = true;
        return;
      }
      this.jdField_a_of_type_OrgLibpagPAGFile = null;
      this.b = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      this.jdField_a_of_type_OrgLibpagPAGFile = null;
      this.b = null;
    }
  }
  
  private void a(@NonNull Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131558496, this, true);
    this.jdField_a_of_type_DovComQqImAeCmshowAECMShowSquareLayout = ((AECMShowSquareLayout)findViewById(2131364782));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380087));
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_OrgLibpagPAGView = new PAGView(paramContext);
      paramContext = new ViewGroup.LayoutParams(-1, -1);
      this.jdField_a_of_type_DovComQqImAeCmshowAECMShowSquareLayout.addView(this.jdField_a_of_type_OrgLibpagPAGView, paramContext);
    }
    bnrh.a("AECMShowLoadingView", "[initViews] mPagInitSucceeded=" + this.jdField_a_of_type_Boolean);
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_OrgLibpagPAGView != null) && (this.jdField_a_of_type_OrgLibpagPAGFile != null))
    {
      this.jdField_a_of_type_OrgLibpagPAGView.setFile(this.jdField_a_of_type_OrgLibpagPAGFile);
      this.jdField_a_of_type_OrgLibpagPAGView.setRepeatCount(0);
      if (!this.jdField_a_of_type_OrgLibpagPAGView.isPlaying()) {
        this.jdField_a_of_type_OrgLibpagPAGView.play();
      }
    }
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_OrgLibpagPAGView != null) && (this.b != null))
    {
      this.jdField_a_of_type_OrgLibpagPAGView.setFile(this.b);
      this.jdField_a_of_type_OrgLibpagPAGView.setRepeatCount(1);
      this.jdField_a_of_type_OrgLibpagPAGView.addListener(new bnip(this));
      if (!this.jdField_a_of_type_OrgLibpagPAGView.isPlaying()) {
        this.jdField_a_of_type_OrgLibpagPAGView.play();
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getContext().getString(2131689675, new Object[] { Integer.valueOf(paramInt) }));
    }
  }
  
  public void a(int paramInt, @Nullable String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Int == 1) {
      b();
    }
    while (this.jdField_a_of_type_Int != 2) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.cmshow.AECMShowLoadingView
 * JD-Core Version:    0.7.0.1
 */