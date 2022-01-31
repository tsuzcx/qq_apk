package dov.com.qq.im;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import bhtg;
import bhtr;

public class AEStoryGIFPreviewActivity
  extends BaseVMPeakActivity
{
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
    setContentView(2131492967);
    paramBundle = getIntent().getStringExtra("KEY_PREVIEW_SOURCE_PATH");
    int i = getIntent().getIntExtra("AECAMERA_MODE", 200);
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("KEY_MATERIAL_APPLIED", false);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("KEY_AVAILABLE_SAVENAME");
    long l = getIntent().getLongExtra("KEY_AVAILABLE_EMO_COUNT", 9223372036854775807L);
    FragmentManager localFragmentManager = getFragmentManager();
    if (i == 202) {
      if (localFragmentManager.findFragmentByTag(bhtg.class.getSimpleName()) == null) {
        localFragmentManager.beginTransaction().add(2131301060, bhtg.a(paramBundle, l), bhtg.class.getSimpleName()).commit();
      }
    }
    while (localFragmentManager.findFragmentByTag(bhtr.class.getSimpleName()) != null) {
      return;
    }
    localFragmentManager.beginTransaction().add(2131301060, bhtr.a(paramBundle, Boolean.valueOf(this.jdField_a_of_type_Boolean), this.jdField_a_of_type_JavaLangString), bhtr.class.getSimpleName()).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.AEStoryGIFPreviewActivity
 * JD-Core Version:    0.7.0.1
 */