package com.tencent.mobileqq.qqlive.prepare.covercrop;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.QPublicFragmentActivityForTool;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.upload.IQQLiveModuleFileUpload;
import com.tencent.mobileqq.qqlive.base.QQLiveBaseFragment;
import com.tencent.mobileqq.qqlive.data.CoverInfo;
import com.tencent.mobileqq.qqlive.data.upload.QQLiveUploadBitmapParams;
import com.tencent.mobileqq.qqlive.widget.RegionView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

public class QQLivePhotoCropFragment
  extends QQLiveBaseFragment
{
  private static int b = 5;
  private ViewGroup c;
  private String d;
  private String e;
  private ImageView f;
  private ImageView g;
  private ImageView h;
  private View i;
  private View j;
  private View k;
  private TextView l;
  private TextView m;
  private TextView n;
  private TextView o;
  private View p;
  private View q;
  private View r;
  private View s;
  private int t = 1;
  private LoadBitmapTask u;
  private LoadBitmapTask v;
  private LoadBitmapTask w;
  private boolean x = false;
  private final CoverInfo y = new CoverInfo();
  
  private void a()
  {
    Intent localIntent = getQBaseActivity().getIntent();
    this.d = localIntent.getStringExtra("SINGLE_PHOTO_PATH");
    this.e = localIntent.getStringExtra("room_id");
  }
  
  private void a(int paramInt)
  {
    this.t = paramInt;
    this.l.setTextColor(-1);
    this.m.setTextColor(-1);
    this.n.setTextColor(-1);
    this.i.setVisibility(8);
    this.j.setVisibility(8);
    this.k.setVisibility(8);
    Object localObject = this.u;
    if (localObject != null)
    {
      ((LoadBitmapTask)localObject).a(false);
      this.v.a(false);
      this.w.a(false);
    }
    if (paramInt == 1)
    {
      localObject = this.u;
      if (localObject != null) {
        ((LoadBitmapTask)localObject).a(true);
      }
      localObject = this.w;
      if ((localObject != null) && (((LoadBitmapTask)localObject).a() != null))
      {
        localObject = this.v;
        if ((localObject != null) && (((LoadBitmapTask)localObject).a() != null))
        {
          localObject = this.w.a().getBitmap();
          this.h.setImageBitmap((Bitmap)localObject);
          localObject = this.v.a().getBitmap();
          this.g.setImageBitmap((Bitmap)localObject);
        }
      }
      this.l.setTextColor(getResources().getColor(2131165499));
      this.i.setVisibility(0);
      this.f.setBackgroundResource(2130848125);
      return;
    }
    if (paramInt == 2)
    {
      localObject = this.v;
      if (localObject != null) {
        ((LoadBitmapTask)localObject).a(true);
      }
      localObject = this.u;
      if ((localObject != null) && (((LoadBitmapTask)localObject).a() != null))
      {
        localObject = this.w;
        if ((localObject != null) && (((LoadBitmapTask)localObject).a() != null))
        {
          localObject = this.u.a().getBitmap();
          this.f.setImageBitmap((Bitmap)localObject);
          localObject = this.w.a().getBitmap();
          this.h.setImageBitmap((Bitmap)localObject);
        }
      }
      this.m.setTextColor(getResources().getColor(2131165499));
      this.j.setVisibility(0);
      this.g.setBackgroundResource(2130848125);
      return;
    }
    if (paramInt == 3)
    {
      localObject = this.w;
      if (localObject != null) {
        ((LoadBitmapTask)localObject).a(true);
      }
      localObject = this.v;
      if ((localObject != null) && (((LoadBitmapTask)localObject).a() != null))
      {
        localObject = this.u;
        if ((localObject != null) && (((LoadBitmapTask)localObject).a() != null))
        {
          localObject = this.u.a().getBitmap();
          this.f.setImageBitmap((Bitmap)localObject);
          localObject = this.v.a().getBitmap();
          this.g.setImageBitmap((Bitmap)localObject);
        }
      }
      this.n.setTextColor(getResources().getColor(2131165499));
      this.k.setVisibility(0);
      this.h.setBackgroundResource(2130848125);
    }
  }
  
  public static final void a(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    QPublicFragmentActivityForTool.a(paramActivity, paramIntent, QQLivePhotoCropFragment.class, paramInt);
  }
  
  private void b()
  {
    QBaseActivity localQBaseActivity = getQBaseActivity();
    int i1 = ViewUtils.getScreenWidth();
    this.u = new LoadBitmapTask(1, this.t, localQBaseActivity, this.c, this.f, this.d, i1, i1);
    this.u.a(false);
    i1 = ViewUtils.getScreenWidth();
    int i2 = i1 * 24 / 17;
    this.v = new LoadBitmapTask(2, this.t, localQBaseActivity, this.c, this.g, this.d, i1, i2);
    this.v.a(false);
    i1 = ViewUtils.getScreenWidth();
    i2 = i1 / 3;
    this.w = new LoadBitmapTask(3, this.t, localQBaseActivity, this.c, this.h, this.d, i1, i2 * 4);
    this.w.a(false);
  }
  
  private void c()
  {
    int i1 = b;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            if (i1 != 4)
            {
              if (i1 != 5)
              {
                this.o.setText("封面将以三种比例展示，点击可调整裁剪效果");
                this.p.setVisibility(0);
                a(1);
                return;
              }
              this.o.setText("可手动调整封面显示范围");
              this.p.setVisibility(4);
              a(2);
              return;
            }
            this.o.setText("封面将以两种比例展示，点击可调整裁剪效果");
            this.p.setVisibility(0);
            this.q.setVisibility(8);
            localLayoutParams = (FrameLayout.LayoutParams)this.s.getLayoutParams();
            localLayoutParams.gravity = 17;
            localLayoutParams.rightMargin = ViewUtils.dip2px(97.0F);
            this.s.setLayoutParams(localLayoutParams);
            localLayoutParams = (FrameLayout.LayoutParams)this.r.getLayoutParams();
            localLayoutParams.gravity = 17;
            localLayoutParams.leftMargin = 0;
            this.r.setLayoutParams(localLayoutParams);
            a(2);
            return;
          }
          this.o.setText("可手动调整封面显示范围");
          this.p.setVisibility(4);
          a(3);
          return;
        }
        this.o.setText("封面将以两种比例展示，点击可调整裁剪效果");
        this.p.setVisibility(0);
        this.r.setVisibility(8);
        a(1);
        return;
      }
      this.o.setText("封面将以两种比例展示，点击可调整裁剪效果");
      this.p.setVisibility(0);
      this.s.setVisibility(8);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.r.getLayoutParams();
      localLayoutParams.gravity = 17;
      localLayoutParams.leftMargin = 0;
      this.r.setLayoutParams(localLayoutParams);
      a(1);
      return;
    }
    this.o.setText("可手动调整封面显示范围");
    this.p.setVisibility(4);
    a(1);
  }
  
  private void d()
  {
    if (this.x)
    {
      QLog.d("QQLivePhotoCropFragment", 1, "the upload task is running ");
      return;
    }
    this.x = true;
    Object localObject = this.v;
    if (localObject != null)
    {
      if (((LoadBitmapTask)localObject).a() == null) {
        return;
      }
      try
      {
        localObject = this.a.getFileUploadModule();
        if (localObject != null)
        {
          QQLiveUploadBitmapParams localQQLiveUploadBitmapParams = new QQLiveUploadBitmapParams();
          localQQLiveUploadBitmapParams.flag = this.a.getAppId();
          localQQLiveUploadBitmapParams.format = "16:9";
          localQQLiveUploadBitmapParams.roomId = String.valueOf(this.e);
          localQQLiveUploadBitmapParams.useTestEnv = false;
          ((IQQLiveModuleFileUpload)localObject).uploadBitmap(this.v.a().getBitmap(), localQQLiveUploadBitmapParams, new QQLivePhotoCropFragment.6(this));
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("QQLivePhotoCropFragment", 1, localThrowable.getMessage());
      }
    }
  }
  
  private void e()
  {
    QBaseActivity localQBaseActivity = getQBaseActivity();
    if ((localQBaseActivity != null) && (!localQBaseActivity.isFinishing())) {
      localQBaseActivity.finish();
    }
  }
  
  protected void a(View paramView)
  {
    this.c = ((ViewGroup)paramView.findViewById(2131440222));
    this.f = ((ImageView)paramView.findViewById(2131436530));
    this.g = ((ImageView)paramView.findViewById(2131436529));
    this.h = ((ImageView)paramView.findViewById(2131436531));
    this.i = paramView.findViewById(2131449836);
    this.j = paramView.findViewById(2131449835);
    this.k = paramView.findViewById(2131449837);
    this.l = ((TextView)paramView.findViewById(2131448685));
    this.m = ((TextView)paramView.findViewById(2131448684));
    this.n = ((TextView)paramView.findViewById(2131448686));
    this.o = ((TextView)paramView.findViewById(2131448810));
    this.p = paramView.findViewById(2131433240);
    paramView.findViewById(2131436318).setOnClickListener(new QQLivePhotoCropFragment.1(this));
    paramView.findViewById(2131448718).setOnClickListener(new QQLivePhotoCropFragment.2(this));
    this.q = paramView.findViewById(2131437537);
    this.q.setOnClickListener(new QQLivePhotoCropFragment.3(this));
    this.s = paramView.findViewById(2131437536);
    this.s.setOnClickListener(new QQLivePhotoCropFragment.4(this));
    this.r = paramView.findViewById(2131437538);
    this.r.setOnClickListener(new QQLivePhotoCropFragment.5(this));
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = paramLayoutInflater.inflate(2131627984, null);
    a();
    a(paramLayoutInflater);
    c();
    b();
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.prepare.covercrop.QQLivePhotoCropFragment
 * JD-Core Version:    0.7.0.1
 */