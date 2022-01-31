package me.ele.uetool;

import android.app.Activity;
import android.content.Intent;
import android.media.projection.MediaProjectionManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Toast;
import me.ele.uetool.base.Application;
import me.ele.uetool.dialog.AttrsDialog;
import me.ele.uetool.util.ImageCapture;
import me.ele.uetool.util.JarResource;
import me.ele.uetool.util.Util;
import me.ele.uetool.view.BaseLineView;
import me.ele.uetool.view.BoardTextView;
import me.ele.uetool.view.ColorPickerFloatView;
import me.ele.uetool.view.EditAttrLayout;
import me.ele.uetool.view.HierarchyView;
import me.ele.uetool.view.RelativePositionLayout;

public class TransparentActivity
  extends Activity
{
  private static final int CAPTURE_SCREEN = 1;
  public static final String EXTRA_TYPE = "extra_type";
  public static final int REQUEST_PICK_IMAGE = 1;
  private BaseLineView baseLineView;
  private EditAttrLayout curEditAttrLayout;
  private HierarchyView hierarchyView;
  private boolean isTop = false;
  private HierarchyView showHierarchyView;
  private int type;
  private ViewGroup vContainer;
  
  private boolean requestCaptureScreen()
  {
    if (Build.VERSION.SDK_INT < 21) {
      return false;
    }
    MediaProjectionManager localMediaProjectionManager = (MediaProjectionManager)getSystemService("media_projection");
    if (localMediaProjectionManager == null) {
      return false;
    }
    startActivityForResult(localMediaProjectionManager.createScreenCaptureIntent(), 1);
    return true;
  }
  
  @RequiresApi(api=21)
  private void showColorPicker(Intent paramIntent)
  {
    Log.i("showColorPicker", "showColorPicker: ");
    ColorPickerFloatView localColorPickerFloatView = new ColorPickerFloatView(Application.getApplicationContext());
    ImageCapture localImageCapture = new ImageCapture();
    localImageCapture.init(this, paramIntent.getExtras());
    localColorPickerFloatView.setmImageCapture(localImageCapture);
    localColorPickerFloatView.addToWindow();
  }
  
  public void changeHierarchyView(View paramView)
  {
    if (this.showHierarchyView == null)
    {
      this.showHierarchyView = new HierarchyView(this);
      this.showHierarchyView.onViewEnterAnimEnd(paramView);
      this.showHierarchyView.setEditAttrLayout(this.curEditAttrLayout);
      this.showHierarchyView.setRemoveView(new TransparentActivity.4(this));
      this.vContainer.addView(this.showHierarchyView);
      this.isTop = true;
    }
    do
    {
      return;
      this.showHierarchyView.onViewEnterAnimEnd(paramView);
    } while (this.isTop);
    this.vContainer.addView(this.showHierarchyView);
  }
  
  public void dismissAttrsDialog()
  {
    int i = 0;
    while (i < this.vContainer.getChildCount())
    {
      View localView = this.vContainer.getChildAt(i);
      if ((localView instanceof EditAttrLayout)) {
        ((EditAttrLayout)localView).dismissAttrsDialog();
      }
      i += 1;
    }
  }
  
  public void finish()
  {
    AttrsDialog.setContext(null);
    if (this.hierarchyView != null) {}
    try
    {
      this.vContainer.removeView(this.hierarchyView);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        localIllegalArgumentException.printStackTrace();
        this.hierarchyView = null;
      }
    }
    finally
    {
      this.hierarchyView = null;
    }
    if (this.curEditAttrLayout != null) {
      this.curEditAttrLayout = null;
    }
    if (this.showHierarchyView != null) {
      this.showHierarchyView = null;
    }
    UETool.getInstance().getUetMenu().changeStatus(this.type, false);
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  public BaseLineView getBaseLineView()
  {
    return this.baseLineView;
  }
  
  public EditAttrLayout getEditAttrLayout()
  {
    return this.curEditAttrLayout;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  @RequiresApi(api=21)
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      showColorPicker(paramIntent);
      finish();
      return;
    }
    Toast.makeText(this, "start color pick fail", 0).show();
    finish();
  }
  
  public void onBackPressed()
  {
    if (this.hierarchyView != null) {}
    try
    {
      this.vContainer.removeView(this.hierarchyView);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        localIllegalArgumentException.printStackTrace();
        this.hierarchyView = null;
      }
    }
    finally
    {
      this.hierarchyView = null;
    }
    if (this.baseLineView != null)
    {
      this.vContainer.removeView(this.baseLineView);
      UETool.getInstance().setBaseLineView(null);
      this.baseLineView = null;
    }
    if (this.curEditAttrLayout != null) {
      this.curEditAttrLayout = null;
    }
    if (this.showHierarchyView != null) {
      this.showHierarchyView = null;
    }
    finish();
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null)
    {
      finish();
      return;
    }
    AttrsDialog.setContext(this);
    Util.setStatusBarColor(getWindow(), 0);
    Util.enableFullscreen(getWindow());
    setContentView(JarResource.getIdByName("layout", "qb_uet_activity_transparent"));
    this.vContainer = ((ViewGroup)findViewById(JarResource.getIdByName("id", "container")));
    paramBundle = new BoardTextView(this);
    this.type = getIntent().getIntExtra("extra_type", -1);
    switch (this.type)
    {
    default: 
      Toast.makeText(this, "coming soon", 0).show();
      finish();
    }
    for (;;)
    {
      Object localObject = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject).gravity = 80;
      this.vContainer.addView(paramBundle, (ViewGroup.LayoutParams)localObject);
      return;
      localObject = new EditAttrLayout(this);
      ((EditAttrLayout)localObject).setOnDragListener(new TransparentActivity.1(this, paramBundle));
      this.curEditAttrLayout = ((EditAttrLayout)localObject);
      this.vContainer.addView((View)localObject);
      continue;
      this.vContainer.addView(new RelativePositionLayout(this));
      continue;
      localObject = new EditAttrLayout(this);
      ((EditAttrLayout)localObject).setOnDragListener(new TransparentActivity.2(this, paramBundle));
      this.curEditAttrLayout = ((EditAttrLayout)localObject);
      this.vContainer.addView((View)localObject);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      this.hierarchyView = new HierarchyView(this);
      this.vContainer.addView(this.hierarchyView, localLayoutParams);
      this.hierarchyView.setEditAttrLayout((EditAttrLayout)localObject);
      this.hierarchyView.setRemoveView(new TransparentActivity.3(this));
      continue;
      this.baseLineView = new BaseLineView(this);
      this.vContainer.addView(this.baseLineView);
      continue;
      requestCaptureScreen();
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    AttrsDialog.setContext(null);
    UETool.getInstance().release();
  }
  
  protected void onStop()
  {
    finish();
    AttrsDialog.setContext(null);
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     me.ele.uetool.TransparentActivity
 * JD-Core Version:    0.7.0.1
 */