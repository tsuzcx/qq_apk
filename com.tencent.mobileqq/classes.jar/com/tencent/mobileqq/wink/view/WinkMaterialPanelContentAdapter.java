package com.tencent.mobileqq.wink.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.QQToast.IToastValidListener;
import com.tencent.mobileqq.wink.edit.log.WinkQLog;
import com.tencent.mobileqq.wink.edit.util.WinkMapReport;
import com.tencent.mobileqq.wink.editor.MetaMaterialKt;
import com.tencent.mobileqq.wink.flow.ApplyMaterialTask;
import com.tencent.mobileqq.wink.flow.ApplyMaterialTask.Status;
import com.tencent.mobileqq.wink.flow.ApplyMaterialTaskHelper;
import com.tencent.mobileqq.wink.utils.AdapterUtils;
import com.tencent.mobileqq.wink.utils.ViewUtilsKt;
import com.tencent.mobileqq.winkpublish.api.IUploadCommonSetting;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mqq.os.MqqHandler;

public abstract class WinkMaterialPanelContentAdapter
  extends RecyclerView.Adapter<WinkMaterialPanelContentAdapter.ContentItemVH>
{
  private final int a;
  private RecyclerView b;
  private List<MetaMaterial> c;
  private int d = -1;
  private int e;
  private boolean f = false;
  private boolean g = false;
  private boolean h = false;
  private ApplyMaterialTask i;
  private WinkMaterialPanelContentAdapter.ItemListener j;
  private QQToast.IToastValidListener k;
  private final int l;
  private final int m;
  private final int n;
  private final int o;
  
  public WinkMaterialPanelContentAdapter(@NonNull Context paramContext)
  {
    this(paramContext, 1);
  }
  
  public WinkMaterialPanelContentAdapter(@NonNull Context paramContext, int paramInt)
  {
    this.a = paramInt;
    this.c = new ArrayList();
    this.l = DisplayUtil.a(paramContext, 20.0F);
    this.m = DisplayUtil.a(paramContext, 6.0F);
    this.n = DisplayUtil.a(paramContext, 2.0F);
    this.o = DisplayUtil.a(paramContext, 16.0F);
  }
  
  private void a(@NonNull MetaMaterial paramMetaMaterial, String paramString)
  {
    if (paramMetaMaterial != null)
    {
      long l1 = WinkMapReport.a().b(paramMetaMaterial.id);
      if (l1 > 0L)
      {
        ((IUploadCommonSetting)QRoute.api(IUploadCommonSetting.class)).reportPublishQuality(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).pMaterialDownloadFinish(), Arrays.asList(new FeedCloudCommon.Entry[] { ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).ext1(), paramMetaMaterial.id), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).ext3(), String.valueOf(l1)), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).keyRetCode(), paramString) }));
        return;
      }
      WinkQLog.b("MaterialPanelContentAdapter", "reportMaterialDownloadCost time < 0");
    }
  }
  
  private void a(ApplyMaterialTask.Status paramStatus, int paramInt, MetaMaterial paramMetaMaterial)
  {
    ApplyMaterialTaskHelper.a("onPostDownloadMaterial", paramMetaMaterial, "start");
    this.i.a(paramStatus, paramInt, paramMetaMaterial, new -..Lambda.WinkMaterialPanelContentAdapter.mjXxlB1-FPi_xRAe6-j6G3QyNIk(this, paramMetaMaterial, paramStatus, paramInt));
  }
  
  private void b(int paramInt, MetaMaterial paramMetaMaterial)
  {
    if (paramMetaMaterial == null) {
      return;
    }
    if ((!this.h) && (paramInt == this.d) && (!this.f)) {
      return;
    }
    this.f = false;
    this.e = paramInt;
    c(paramInt, paramMetaMaterial);
  }
  
  private void c(int paramInt, @NonNull MetaMaterial paramMetaMaterial)
  {
    if (this.i == null) {
      return;
    }
    ApplyMaterialTaskHelper.a("onPreExecute", paramMetaMaterial, "start");
    if (paramMetaMaterial != null) {
      WinkMapReport.a().a(paramMetaMaterial.id);
    }
    this.i.a(paramInt, paramMetaMaterial, new -..Lambda.WinkMaterialPanelContentAdapter.Qe1sKBOS5liU6lSrsewyYvyeB7Q(this, paramMetaMaterial, paramInt));
  }
  
  private void d(int paramInt, MetaMaterial paramMetaMaterial)
  {
    MetaMaterialKt.b(paramMetaMaterial, -1);
    ThreadManager.getUIHandler().post(new -..Lambda.WinkMaterialPanelContentAdapter.OcMt9b_nOoYuIslKcNGFywOALQ4(this, paramInt));
  }
  
  public int a()
  {
    return this.d;
  }
  
  protected abstract WinkMaterialPanelContentAdapter.ContentItemVH a(ViewGroup paramViewGroup, int paramInt);
  
  public void a(int paramInt)
  {
    a(paramInt, false);
  }
  
  public void a(int paramInt, MetaMaterial paramMetaMaterial)
  {
    b(paramInt, paramMetaMaterial);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(getClass().getSimpleName());
      ((StringBuilder)localObject).append(" setSelectedIndex:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("MaterialPanelContentAdapter", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt >= 0)
    {
      localObject = this.b;
      if ((localObject != null) && ((((RecyclerView)localObject).getLayoutManager() instanceof LinearLayoutManager))) {
        if (((LinearLayoutManager)this.b.getLayoutManager()).getOrientation() == 0) {
          AdapterUtils.a(this.b, this.d, paramInt, paramBoolean, false);
        } else {
          AdapterUtils.b(this.b, this.d, paramInt, paramBoolean, false);
        }
      }
    }
    this.d = paramInt;
    notifyDataSetChanged();
  }
  
  public void a(ApplyMaterialTask paramApplyMaterialTask)
  {
    this.i = paramApplyMaterialTask;
  }
  
  public final void a(WinkMaterialPanelContentAdapter.ContentItemVH paramContentItemVH, int paramInt)
  {
    MetaMaterial localMetaMaterial = (MetaMaterial)this.c.get(paramInt);
    boolean bool2 = false;
    if (localMetaMaterial != null)
    {
      if ("ID_PLACEHOLDER".equals(localMetaMaterial.id))
      {
        if (paramContentItemVH.itemView.getVisibility() == 4) {
          break label510;
        }
        paramContentItemVH.itemView.setVisibility(4);
        break label510;
      }
      if (paramContentItemVH.itemView.getVisibility() != 0) {
        paramContentItemVH.itemView.setVisibility(0);
      }
    }
    Object localObject = this.j;
    if (localObject != null) {
      ((WinkMaterialPanelContentAdapter.ItemListener)localObject).a(paramInt, localMetaMaterial);
    }
    if (localMetaMaterial != null)
    {
      int i1;
      if (this.d == paramInt) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (TextUtils.isEmpty(localMetaMaterial.thumbUrl))
      {
        paramContentItemVH.c.setVisibility(0);
        paramContentItemVH.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
      }
      else if (localMetaMaterial.thumbUrl.startsWith("http"))
      {
        paramContentItemVH.c.setVisibility(0);
        paramContentItemVH.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ViewUtilsKt.a(paramContentItemVH.c, localMetaMaterial.thumbUrl, DisplayUtil.a(paramContentItemVH.c.getContext(), 67.0F), DisplayUtil.a(paramContentItemVH.c.getContext(), 67.0F), null, null);
      }
      else
      {
        paramContentItemVH.c.setVisibility(0);
        paramContentItemVH.c.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        paramContentItemVH.c.setImageResource(MetaMaterialKt.k(localMetaMaterial));
      }
      if (MetaMaterialKt.j(localMetaMaterial) != -1) {
        paramContentItemVH.b.setCardBackgroundColor(MetaMaterialKt.j(localMetaMaterial));
      }
      if (paramContentItemVH.h != null)
      {
        paramContentItemVH.h.setText(MetaMaterialKt.b(localMetaMaterial));
        localObject = paramContentItemVH.h;
        Resources localResources = paramContentItemVH.itemView.getContext().getResources();
        int i2;
        if (i1 != 0) {
          i2 = 2131165865;
        } else {
          i2 = 2131165866;
        }
        ((TextView)localObject).setTextColor(localResources.getColor(i2));
      }
      if (i1 != 0)
      {
        paramContentItemVH.d.setVisibility(0);
        WinkMaterialPanelContentAdapter.ContentItemVH.a(paramContentItemVH, false, -1);
        WinkMaterialPanelContentAdapter.ContentItemVH.a(paramContentItemVH, false);
      }
      else
      {
        paramContentItemVH.d.setVisibility(4);
        if (MetaMaterialKt.g(localMetaMaterial))
        {
          i1 = MetaMaterialKt.h(localMetaMaterial);
          if ((i1 != -1) && (i1 != 100))
          {
            WinkMaterialPanelContentAdapter.ContentItemVH.a(paramContentItemVH, true, i1);
          }
          else
          {
            WinkMaterialPanelContentAdapter.ContentItemVH.a(paramContentItemVH, false, i1);
            localObject = this.i;
            if (localObject != null)
            {
              boolean bool3 = ((ApplyMaterialTask)localObject).b(paramInt, localMetaMaterial);
              boolean bool1 = bool2;
              if (i1 == -1)
              {
                bool1 = bool2;
                if (!bool3)
                {
                  bool1 = bool2;
                  if (MetaMaterialKt.c(localMetaMaterial)) {
                    bool1 = true;
                  }
                }
              }
              WinkMaterialPanelContentAdapter.ContentItemVH.a(paramContentItemVH, bool1);
            }
          }
        }
      }
      paramContentItemVH.itemView.setOnClickListener(new -..Lambda.WinkMaterialPanelContentAdapter.JVWl9jOqWl3xquXIano7v4OOUVU(this, paramInt, localMetaMaterial));
      a(paramContentItemVH, paramInt, localMetaMaterial);
    }
    label510:
    EventCollector.getInstance().onRecyclerBindViewHolder(paramContentItemVH, paramInt, getItemId(paramInt));
  }
  
  protected void a(WinkMaterialPanelContentAdapter.ContentItemVH paramContentItemVH, int paramInt, @NonNull MetaMaterial paramMetaMaterial) {}
  
  public final void a(List<MetaMaterial> paramList)
  {
    this.c = paramList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.c == null) {
        return false;
      }
      int i1 = 0;
      while (i1 < this.c.size())
      {
        if ((this.c.get(i1) != null) && (paramString.equals(((MetaMaterial)this.c.get(i1)).id)))
        {
          a(i1, (MetaMaterial)this.c.get(i1));
          return true;
        }
        i1 += 1;
      }
    }
    return false;
  }
  
  public final WinkMaterialPanelContentAdapter.ContentItemVH b(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = a(paramViewGroup, paramInt);
    if (this.a == 1)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramViewGroup.itemView.getLayoutParams();
      if (paramInt == 0) {
        localLayoutParams.leftMargin = this.l;
      } else if (paramInt == 2) {
        localLayoutParams.rightMargin = this.l;
      }
    }
    WinkMaterialPanelContentAdapter.ContentItemVH.a(paramViewGroup, this.m, this.n, this.o);
    return paramViewGroup;
  }
  
  public void b(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void c(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public final int getItemCount()
  {
    List localList = this.c;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    List localList = this.c;
    if ((localList != null) && (paramInt == localList.size() - 1)) {
      return 2;
    }
    return 1;
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    this.b = paramRecyclerView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.view.WinkMaterialPanelContentAdapter
 * JD-Core Version:    0.7.0.1
 */