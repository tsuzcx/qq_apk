package com.tencent.mobileqq.filemanager.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.filemanager.data.FileCategoryEntity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.LocalFileAdapter;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.BubblePopupWindow;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LocalFileBrowserActivity
  extends BaseFileAssistantActivity
  implements View.OnClickListener
{
  public static String F = "LocalFileBrowserActivity<FileAssistant>";
  TextView G;
  TextView H;
  EditText I = null;
  NoFileRelativeLayout J = null;
  SlideDetectListView K = null;
  LinearLayout L = null;
  LocalFileAdapter M = null;
  String N;
  ArrayList<FileInfo> O = new ArrayList();
  int P = -1;
  int Q = 0;
  boolean R = false;
  String S;
  QBaseActivity T;
  BubblePopupWindow U = null;
  Map<String, Integer> V = new HashMap();
  boolean W;
  boolean X = true;
  public View.OnLongClickListener Y = new LocalFileBrowserActivity.5(this);
  public View.OnClickListener Z = new LocalFileBrowserActivity.6(this);
  protected AdapterView.OnItemClickListener aa = new LocalFileBrowserActivity.8(this);
  private AsyncTask ab = null;
  
  private void N()
  {
    if (this.O.size() == 0) {
      this.J.setGone();
    } else {
      this.J.setVisible(true);
    }
    this.M.notifyDataSetChanged();
  }
  
  private void O()
  {
    this.K = ((SlideDetectListView)findViewById(2131437341));
    this.J = ((NoFileRelativeLayout)findViewById(2131439351));
    this.J.setText(2131888916);
    this.K.setOnItemClickListener(this.aa);
    this.K.setEmptyView(this.J);
    this.J.setGone();
    int i = this.Q;
    if ((i != 7) && (i != 8) && (i != 11))
    {
      this.M.a(this.K);
      return;
    }
    c(false);
  }
  
  private void P()
  {
    int i = this.Q;
    if (i != 6) {
      if (i != 7)
      {
        if (i != 8)
        {
          if (i != 11)
          {
            if (i != 23) {
              break label103;
            }
          }
          else
          {
            File localFile = (File)QQFileManagerUtil.b(this).get("externalSdCard");
            if (localFile == null)
            {
              this.N = "/";
              break label103;
            }
            this.N = localFile.getPath();
            break label103;
          }
        }
        else
        {
          this.N = AppConstants.SDCARD_ROOT;
          break label103;
        }
      }
      else
      {
        this.N = "/";
        break label103;
      }
    }
    this.N = AppConstants.SDCARD_FILE_SAVE_PATH;
    label103:
    this.S = this.N;
  }
  
  private void Q()
  {
    Object localObject = AppConstants.SDCARD_FILE_SAVE_PATH;
    String str = AppConstants.SDCARD_FILE_SAVE_TMP_PATH;
    File localFile = new File((String)localObject);
    if (!FileUtils.fileExists((String)localObject)) {
      localFile.mkdirs();
    }
    localObject = new File(str);
    if (!FileUtils.fileExists(str)) {
      ((File)localObject).mkdirs();
    }
  }
  
  private void R()
  {
    this.g = getString(FileCategoryEntity.a(this.Q));
    setTitle(this.g);
    if (this.G == null) {
      this.G = ((TextView)findViewById(2131436227));
    }
    this.H = this.leftView;
    TextView localTextView = this.H;
    if (localTextView != null) {
      localTextView.setOnClickListener(new LocalFileBrowserActivity.7(this));
    }
    this.H = this.leftView;
  }
  
  private boolean S()
  {
    int i = this.Q;
    if (((i == 8) || (i == 11)) && (this.N.equals(this.S))) {
      return super.onBackEvent();
    }
    i = this.Q;
    if (i == 6) {
      return super.onBackEvent();
    }
    if (i == 23)
    {
      finish();
      return false;
    }
    String str = new File(this.N).getParent();
    if (str != null)
    {
      a(str, false);
      return false;
    }
    return super.onBackEvent();
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (paramString != null)
    {
      String str = paramString;
      if (paramString.length() == 0) {
        return;
      }
      do
      {
        paramString = new File(str);
        if (paramString.exists()) {
          break;
        }
        paramString = paramString.getParent();
        str = paramString;
      } while (paramString != null);
      str = paramString;
      if (str == null) {
        return;
      }
      if (paramBoolean)
      {
        i = this.K.getFirstVisiblePosition();
        this.V.put(this.N, Integer.valueOf(i));
      }
      else if (this.V.containsKey(this.N))
      {
        this.V.remove(this.N);
      }
      this.N = str;
      this.I.setText(this.N);
      int i = this.Q;
      if ((i != 6) && ((i == 7) || (i == 8) || (i == 11))) {
        if (this.N.equalsIgnoreCase(this.S)) {
          this.H.setText(2131889353);
        } else {
          this.H.setText(2131889620);
        }
      }
      paramString = this.ab;
      if (paramString != null) {
        paramString.cancel(true);
      }
      a(paramBoolean, str);
    }
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    this.ab = new LocalFileBrowserActivity.9(this, paramBoolean).execute(new String[] { paramString });
  }
  
  private void e(int paramInt)
  {
    N();
    this.K.setSelected(true);
    this.K.setSelection(paramInt);
    this.K.setSelected(true);
    this.K.post(new LocalFileBrowserActivity.10(this, paramInt));
  }
  
  public void c()
  {
    N();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131627045);
    paramBundle = getIntent();
    this.Q = paramBundle.getBundleExtra("bundle").getInt("category");
    this.R = paramBundle.getBooleanExtra("open_with_qq_images", false);
    this.T = this;
    P();
    Q();
    R();
    this.I = ((EditText)findViewById(2131431525));
    this.L = ((LinearLayout)findViewById(2131437244));
    this.M = new LocalFileAdapter(this, this.O, this);
    O();
    this.K.setAdapter(this.M);
    this.K.setOnItemClickListener(this.aa);
    this.K.setOnScrollToTopListener(new LocalFileBrowserActivity.1(this));
    a(this.N, true);
    if (this.Q == 6) {
      this.L.setVisibility(8);
    }
    if (paramBundle.getIntExtra("localSdCardfile", -1) != -1)
    {
      this.a.setEditBtnVisible(false);
      f();
    }
    this.W = paramBundle.getBooleanExtra("select_file_only_docs_file", false);
    this.a.setDocsCheck(this.W);
    if (this.W) {
      this.a.setOnlyDocsChecked();
    }
    B();
    return true;
  }
  
  protected void doOnDestroy()
  {
    AsyncTask localAsyncTask = this.ab;
    if (localAsyncTask != null) {
      localAsyncTask.cancel(true);
    }
    this.ab = null;
    super.doOnDestroy();
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void onBackPressed()
  {
    S();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity
 * JD-Core Version:    0.7.0.1
 */