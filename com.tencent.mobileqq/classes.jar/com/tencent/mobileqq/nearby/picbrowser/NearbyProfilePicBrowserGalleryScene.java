package com.tencent.mobileqq.nearby.picbrowser;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.galleryactivity.AbstractImageListModel;
import com.tencent.mobileqq.picbrowser.PicBrowserActivity;
import com.tencent.mobileqq.picbrowser.PicBrowserGalleryScene;
import com.tencent.mobileqq.picbrowser.PicBrowserModel;
import com.tencent.mobileqq.picbrowser.PicInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.AdapterView;
import java.util.ArrayList;

public class NearbyProfilePicBrowserGalleryScene
  extends PicBrowserGalleryScene
  implements View.OnClickListener
{
  private TextView f;
  private TextView g;
  private int h = 0;
  
  public NearbyProfilePicBrowserGalleryScene(PicBrowserActivity paramPicBrowserActivity, AbstractImageListModel paramAbstractImageListModel)
  {
    super(paramPicBrowserActivity, paramAbstractImageListModel);
  }
  
  protected RelativeLayout a()
  {
    return (RelativeLayout)LayoutInflater.from(this.w).inflate(2131625514, null);
  }
  
  protected void a(int paramInt)
  {
    if (paramInt == this.h) {
      this.f.setVisibility(8);
    } else {
      this.f.setVisibility(0);
    }
    if (this.c.a() <= 1)
    {
      this.f.setVisibility(8);
      this.g.setVisibility(8);
    }
  }
  
  public void b(ViewGroup paramViewGroup)
  {
    super.b(paramViewGroup);
    this.f = ((TextView)paramViewGroup.findViewById(2131445688));
    this.g = ((TextView)paramViewGroup.findViewById(2131431697));
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
  }
  
  public void n()
  {
    ArrayList localArrayList = this.c.f();
    int i = this.h;
    if ((i != 0) && (i < localArrayList.size())) {
      localArrayList.add(0, (PicInfo)localArrayList.remove(this.h));
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("intent_param_pic_infos", localArrayList);
    this.b.setResult(-1, localIntent);
    super.n();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131431697)
    {
      if (i != 2131445688) {
        return;
      }
      this.h = this.c.b();
      this.f.setVisibility(8);
      QQToast.makeText(this.w, this.w.getResources().getString(2131892093), 0).show();
      return;
    }
    i = this.c.b();
    int j = this.h;
    if (i < j) {
      this.h = (j - 1);
    } else if (i == j) {
      if (i == this.c.a() - 1) {
        this.h = (i - 1);
      } else {
        this.h = i;
      }
    }
    E();
    a(this.c.b());
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    super.onItemSelected(paramAdapterView, paramView, paramInt, paramLong);
    a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.picbrowser.NearbyProfilePicBrowserGalleryScene
 * JD-Core Version:    0.7.0.1
 */