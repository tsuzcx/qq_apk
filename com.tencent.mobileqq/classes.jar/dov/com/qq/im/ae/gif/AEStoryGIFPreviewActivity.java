package dov.com.qq.im.ae.gif;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import bitj;
import bitt;
import dov.com.qq.im.BaseVMPeakActivity;
import dov.com.qq.im.ae.SessionWrap;

public class AEStoryGIFPreviewActivity
  extends BaseVMPeakActivity
{
  private SessionWrap jdField_a_of_type_DovComQqImAeSessionWrap;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  
  public boolean a()
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
  
  public void onCreate(Bundle paramBundle)
  {
    this.ad = false;
    super.onCreate(paramBundle);
    setContentView(2131558518);
    paramBundle = getIntent().getStringExtra("KEY_PREVIEW_SOURCE_PATH");
    int i = getIntent().getIntExtra("AECAMERA_MODE", 200);
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("KEY_MATERIAL_APPLIED", false);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("KEY_AVAILABLE_SAVENAME");
    this.jdField_a_of_type_DovComQqImAeSessionWrap = ((SessionWrap)getIntent().getParcelableExtra("ARG_SESSION_INFO"));
    boolean bool = getIntent().getBooleanExtra("ARG_GIF_SEND_TO_AIO", false);
    long l = getIntent().getLongExtra("KEY_AVAILABLE_EMO_COUNT", 9223372036854775807L);
    FragmentManager localFragmentManager = getFragmentManager();
    if (i == 202) {
      if (localFragmentManager.findFragmentByTag(bitj.class.getSimpleName()) == null) {
        localFragmentManager.beginTransaction().add(2131366671, bitj.a(paramBundle, l), bitj.class.getSimpleName()).commit();
      }
    }
    while (localFragmentManager.findFragmentByTag(bitt.class.getSimpleName()) != null) {
      return;
    }
    localFragmentManager.beginTransaction().add(2131366671, bitt.a(paramBundle, Boolean.valueOf(this.jdField_a_of_type_Boolean), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_DovComQqImAeSessionWrap, bool), bitt.class.getSimpleName()).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.AEStoryGIFPreviewActivity
 * JD-Core Version:    0.7.0.1
 */