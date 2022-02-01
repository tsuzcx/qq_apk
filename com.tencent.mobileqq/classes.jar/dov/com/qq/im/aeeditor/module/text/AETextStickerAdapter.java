package dov.com.qq.im.aeeditor.module.text;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.videostory.FastClickUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import dov.com.qq.im.AEReportUtils;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.report.AEBaseReportParam;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.ae.util.AEThemeUtil;
import dov.com.qq.im.ae.view.AEDownLoadingView;
import dov.com.qq.im.aeeditor.manage.AEEditorPagStickerConfig;
import dov.com.qq.im.aeeditor.module.filter.AEEditorResourceManager;
import dov.com.qq.im.aeeditor.module.filter.AdapterUtil;
import dov.com.qq.im.aeeditor.util.AEEditorPagStickerUtil.PrepareCallback;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class AETextStickerAdapter
  extends RecyclerView.Adapter<AETextStickerAdapter.VH>
  implements AEEditorPagStickerUtil.PrepareCallback
{
  private static final int jdField_a_of_type_Int = ViewUtils.a(9.0F);
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private AETextStickerAdapter.AETextStickerListener jdField_a_of_type_DovComQqImAeeditorModuleTextAETextStickerAdapter$AETextStickerListener;
  private AETextStickerAdapter.ColorBarVisibilityListener jdField_a_of_type_DovComQqImAeeditorModuleTextAETextStickerAdapter$ColorBarVisibilityListener;
  private List<AEEditorTextBean> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = AEThemeUtil.a();
  private int b;
  private int c = -1;
  private int d = -1;
  private int e;
  private int f;
  
  public AETextStickerAdapter(AETextStickerAdapter.AETextStickerListener paramAETextStickerListener, AETextStickerAdapter.ColorBarVisibilityListener paramColorBarVisibilityListener)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleTextAETextStickerAdapter$AETextStickerListener = paramAETextStickerListener;
    this.jdField_a_of_type_DovComQqImAeeditorModuleTextAETextStickerAdapter$ColorBarVisibilityListener = paramColorBarVisibilityListener;
  }
  
  private void a(AETextStickerAdapter.VH paramVH, boolean paramBoolean)
  {
    if (paramVH == null) {
      return;
    }
    if (paramBoolean)
    {
      paramVH.jdField_c_of_type_AndroidViewView.setVisibility(0);
      paramVH.d.setVisibility(0);
      paramVH.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(0);
      return;
    }
    paramVH.jdField_c_of_type_AndroidViewView.setVisibility(8);
    paramVH.d.setVisibility(8);
    paramVH.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
  }
  
  private void e(int paramInt)
  {
    boolean bool2 = true;
    this.c = paramInt;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= this.c) || (this.c < 0)) {
      return;
    }
    Object localObject = (AEEditorTextBean)this.jdField_a_of_type_JavaUtilList.get(this.c);
    boolean bool1;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((AEEditorTextBean)localObject).type != 1)
      {
        if (((AEEditorTextBean)localObject).type == 0) {
          bool1 = bool2;
        }
      }
      else {
        localObject = ((AEEditorTextBean)localObject).id;
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAETextStickerAdapter$ColorBarVisibilityListener != null) {
        this.jdField_a_of_type_DovComQqImAeeditorModuleTextAETextStickerAdapter$ColorBarVisibilityListener.a(bool1, (String)localObject);
      }
      AdapterUtil.a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, paramInt, false);
      return;
      bool1 = false;
      break;
      localObject = "";
      bool1 = false;
    }
  }
  
  public int a()
  {
    return this.c;
  }
  
  public AEEditorTextBean a(int paramInt)
  {
    return (AEEditorTextBean)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public AETextStickerAdapter.VH a(ViewGroup paramViewGroup, int paramInt)
  {
    return new AETextStickerAdapter.VH(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558598, paramViewGroup, false));
  }
  
  public void a()
  {
    try
    {
      this.b -= 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void a(AEEditorTextBean paramAEEditorTextBean, int paramInt)
  {
    ThreadManager.getUIHandler().post(new AETextStickerAdapter.2(this, paramAEEditorTextBean, paramInt));
  }
  
  public void a(AEEditorTextBean paramAEEditorTextBean, boolean paramBoolean, @Nullable AEEditorPagStickerConfig paramAEEditorPagStickerConfig)
  {
    AEQLog.a("AETextStickerAdapter", "[onGetPagStickerConfig], succeeded=" + paramBoolean);
    ThreadManager.getUIHandler().post(new AETextStickerAdapter.4(this, paramBoolean, paramAEEditorPagStickerConfig, paramAEEditorTextBean));
  }
  
  public void a(AEEditorTextBean paramAEEditorTextBean, boolean paramBoolean, @NonNull String paramString)
  {
    ThreadManager.getUIHandler().post(new AETextStickerAdapter.3(this, paramAEEditorTextBean, paramBoolean));
  }
  
  public void a(AETextStickerAdapter.VH paramVH, int paramInt)
  {
    AEEditorTextBean localAEEditorTextBean = (AEEditorTextBean)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    int i;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt))
    {
      AEBaseReportParam.a().a().i = ((AEEditorTextBean)this.jdField_a_of_type_JavaUtilList.get(paramInt)).id;
      if (this.f == 10001) {
        AEReportUtils.e(((AEEditorTextBean)this.jdField_a_of_type_JavaUtilList.get(paramInt)).id);
      }
    }
    else
    {
      AEBaseDataReporter.a().t();
      if (paramInt != this.c) {
        break label310;
      }
      i = 1;
      label105:
      if ((localAEEditorTextBean.type != 1) || (this.e != 2) || (!AEEditorResourceManager.a().a(localAEEditorTextBean.id)) || (localAEEditorTextBean.pagThumbFilePath == null) || (!new File(localAEEditorTextBean.pagThumbFilePath).exists())) {
        break label315;
      }
      paramVH.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(BitmapUtils.decodeBitmap(localAEEditorTextBean.thumbPath, true));
      label178:
      if (!localAEEditorTextBean.isDownloading) {
        break label373;
      }
      a(paramVH, true);
      paramVH.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setProgress(localAEEditorTextBean.progress);
      label205:
      if ((i == 0) || (!localAEEditorTextBean.usable)) {
        break label382;
      }
      paramVH.b.setVisibility(0);
      label225:
      if (!TextUtils.isEmpty(localAEEditorTextBean.badgeURL)) {
        break label394;
      }
      paramVH.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      paramVH.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new AETextStickerAdapter.1(this, paramInt, localAEEditorTextBean, paramVH));
      EventCollector.getInstance().onRecyclerBindViewHolder(paramVH, paramInt, getItemId(paramInt));
      return;
      if (this.f != 10002) {
        break;
      }
      AEReportUtils.q(((AEEditorTextBean)this.jdField_a_of_type_JavaUtilList.get(paramInt)).id);
      break;
      label310:
      i = 0;
      break label105;
      label315:
      UIUtils.a(paramVH.jdField_a_of_type_AndroidWidgetImageView, localAEEditorTextBean.thumbUrl, UIUtils.a(paramVH.jdField_a_of_type_AndroidWidgetImageView.getContext(), 67.0F), UIUtils.a(paramVH.jdField_a_of_type_AndroidWidgetImageView.getContext(), 67.0F), paramVH.jdField_a_of_type_AndroidWidgetImageView.getContext().getResources().getDrawable(2130837927), null);
      break label178;
      label373:
      a(paramVH, false);
      break label205;
      label382:
      paramVH.b.setVisibility(8);
      break label225;
      label394:
      paramVH.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      UIUtils.a(paramVH.jdField_c_of_type_AndroidWidgetImageView, localAEEditorTextBean.badgeURL, UIUtils.a(paramVH.jdField_c_of_type_AndroidWidgetImageView.getContext(), 26.0F), UIUtils.a(paramVH.jdField_c_of_type_AndroidWidgetImageView.getContext(), 26.0F), null, null);
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      c(-1);
      AEQLog.d("AETextStickerAdapter", "[findAndSelected] id is null");
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = -1;
    int k;
    while (localIterator.hasNext())
    {
      AEEditorTextBean localAEEditorTextBean = (AEEditorTextBean)localIterator.next();
      j = i + 1;
      i = j;
      if (localAEEditorTextBean.id != null)
      {
        i = j;
        if (localAEEditorTextBean.id.equals(paramString))
        {
          k = 1;
          i = j;
        }
      }
    }
    for (int j = k;; j = 0)
    {
      if (j != 0)
      {
        AEQLog.d("AETextStickerAdapter", "[findAndSelected] success id:" + paramString);
        c(i);
        return;
      }
      AEQLog.d("AETextStickerAdapter", "[findAndSelected] failed id:" + paramString);
      return;
    }
  }
  
  public void a(List<AEEditorTextBean> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void b(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void c(int paramInt)
  {
    if (FastClickUtils.a("AETextStickerAdapter", 200L)) {
      return;
    }
    notifyDataSetChanged();
    e(paramInt);
  }
  
  public void d(int paramInt)
  {
    this.b = paramInt;
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.text.AETextStickerAdapter
 * JD-Core Version:    0.7.0.1
 */