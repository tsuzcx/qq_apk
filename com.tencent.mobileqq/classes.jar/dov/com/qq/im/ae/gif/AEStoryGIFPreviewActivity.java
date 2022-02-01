package dov.com.qq.im.ae.gif;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.BaseVMPeakActivity;
import dov.com.qq.im.ae.SessionWrap;
import dov.com.qq.im.ae.gif.giftext.fragment.AEGIFChunkPreviewFragment;
import dov.com.qq.im.ae.gif.giftext.fragment.AEGIFSinglePreviewFragment;
import dov.com.qq.im.ae.util.AEQLog;

public class AEStoryGIFPreviewActivity
  extends BaseVMPeakActivity
{
  private SessionWrap jdField_a_of_type_DovComQqImAeSessionWrap;
  private String jdField_a_of_type_JavaLangString = null;
  private boolean jdField_a_of_type_Boolean = false;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  private String c;
  private String d = "";
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 21) && (paramInt2 == -1))
    {
      setResult(201);
      finish();
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.onCreate(paramBundle);
    setContentView(2131558610);
    paramBundle = getIntent().getStringExtra("KEY_PREVIEW_SOURCE_PATH");
    getIntent().getIntExtra("AECAMERA_MODE", 200);
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("KEY_MATERIAL_APPLIED", false);
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("ARG_GIF_MATERIAL_ID");
    this.d = getIntent().getStringExtra("KEY_AVAILABLE_SAVENAME");
    this.jdField_a_of_type_DovComQqImAeSessionWrap = ((SessionWrap)getIntent().getParcelableExtra("ARG_SESSION_INFO"));
    boolean bool = getIntent().getBooleanExtra("ARG_GIF_SEND_TO_AIO", false);
    long l = getIntent().getLongExtra("KEY_AVAILABLE_EMO_COUNT", 9223372036854775807L);
    if (getIntent().hasExtra("KEY_FONT_ID")) {
      this.c = getIntent().getStringExtra("KEY_FONT_ID");
    }
    FragmentManager localFragmentManager = getFragmentManager();
    AEQLog.a("BaseActivity2", "[onCreate], materialApplied=" + this.jdField_b_of_type_Boolean + ", materialId=" + this.jdField_b_of_type_JavaLangString);
    if ((!this.jdField_b_of_type_Boolean) && (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {
      if (localFragmentManager.findFragmentByTag(AEGIFChunkPreviewFragment.class.getSimpleName()) == null) {
        localFragmentManager.beginTransaction().add(2131367438, AEGIFChunkPreviewFragment.a(paramBundle, l, this.c), AEGIFChunkPreviewFragment.class.getSimpleName()).commit();
      }
    }
    while (localFragmentManager.findFragmentByTag(AEGIFSinglePreviewFragment.class.getSimpleName()) != null) {
      return;
    }
    localFragmentManager.beginTransaction().add(2131367438, AEGIFSinglePreviewFragment.a(paramBundle, Boolean.valueOf(this.jdField_b_of_type_Boolean), this.jdField_b_of_type_JavaLangString, this.d, this.jdField_a_of_type_DovComQqImAeSessionWrap, bool, this.c), AEGIFSinglePreviewFragment.class.getSimpleName()).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.AEStoryGIFPreviewActivity
 * JD-Core Version:    0.7.0.1
 */