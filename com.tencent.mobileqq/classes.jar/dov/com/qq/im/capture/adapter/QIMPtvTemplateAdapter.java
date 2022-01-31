package dov.com.qq.im.capture.adapter;

import amus;
import amut;
import amux;
import amuy;
import amuz;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.richmedia.FlowCameraConstant;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.common.Observer;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.data.TemplateGroupItem;
import dov.com.qq.im.capture.view.AdvancedProviderView;
import dov.com.qq.im.capture.view.ProviderView.ProviderViewListener;
import dov.com.qq.im.capture.view.QIMCommonLoadingProgress;
import dov.com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import dov.com.tencent.mobileqq.activity.richmedia.PtvTemplateItemView;
import dov.com.tencent.mobileqq.activity.richmedia.ShortVideoMtaReport;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.IPtvTemplateDownloadListener;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QIMPtvTemplateAdapter
  extends BaseAdapter
  implements Observer
{
  public static String a;
  public static int b;
  public static String b;
  float jdField_a_of_type_Float;
  public int a;
  public Context a;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  public GridView a;
  public QIMPtvTemplateAdapter.IPtvTemplateItemCallback a;
  private ProviderView.ProviderViewListener jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener;
  private PtvTemplateManager.IPtvTemplateDownloadListener jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$IPtvTemplateDownloadListener = new amut(this);
  public PtvTemplateManager.PtvTemplateInfo a;
  public QIMPtvTemplateManager a;
  public ArrayList a;
  public PtvTemplateManager.PtvTemplateInfo b;
  public int c;
  private int d;
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
    jdField_b_of_type_JavaLangString = "0";
  }
  
  public QIMPtvTemplateAdapter(Context paramContext, GridView paramGridView, ProviderView.ProviderViewListener paramProviderViewListener, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateAdapter$IPtvTemplateItemCallback = new amus(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentWidgetGridView = paramGridView;
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager = ((QIMPtvTemplateManager)QIMManager.a(3));
    this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener = paramProviderViewListener;
    this.c = paramInt;
  }
  
  public int a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size()) {
      if (!((PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).id.equals(paramPtvTemplateInfo.id)) {}
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QIMPtvTemplateManager", 2, "PtvTemplateAdapter getTemplatePosFromOut: " + i);
      }
      return i;
      i += 1;
      break;
      i = 0;
    }
  }
  
  public PtvTemplateManager.PtvTemplateInfo a(int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
      return null;
    }
    return (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo)
  {
    if (paramPtvTemplateInfo != null) {}
    int i;
    for (;;)
    {
      this.jdField_b_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo = this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo;
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo = paramPtvTemplateInfo;
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)) && (!this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id.equals("0"))) {
        break;
      }
      jdField_b_of_type_Int = paramPtvTemplateInfo.categoryId;
      jdField_b_of_type_JavaLangString = paramPtvTemplateInfo.id;
      if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener != null)
      {
        this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener.a("", false, false);
        jdField_a_of_type_JavaLangString = "";
        if ((FlowCameraConstant.jdField_a_of_type_Int == 2) && (jdField_b_of_type_JavaLangString.equals("0")) && (jdField_b_of_type_Int == 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QIMPtvTemplateManager", 2, "onDrawBeautyFeature is in back_camera && no template is selected");
          }
          this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener.c(0);
          this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener.b(-1, false);
        }
        if (QLog.isColorLevel()) {
          QLog.i("QIMPtvTemplateManager", 2, "setVideoFilter null");
        }
      }
      ((QIMPtvTemplateManager)QIMManager.a(3)).a(113, null);
      if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener != null) {
        this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener.a(null);
      }
      do
      {
        return;
        i = this.d;
      } while (i >= this.jdField_a_of_type_JavaUtilArrayList.size());
      paramPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
    }
    Object localObject;
    if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable)
    {
      jdField_b_of_type_Int = paramPtvTemplateInfo.categoryId;
      jdField_b_of_type_JavaLangString = paramPtvTemplateInfo.id;
      localObject = (QIMPtvTemplateManager)QIMManager.a(3);
      ((QIMPtvTemplateManager)localObject).a(paramPtvTemplateInfo, 111);
      ((QIMPtvTemplateManager)localObject).a(3, paramPtvTemplateInfo.categoryId, paramPtvTemplateInfo.id);
      localObject = QIMPtvTemplateManager.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.name;
      if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.kind == 3)
      {
        this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener.a((String)localObject);
        jdField_a_of_type_JavaLangString = "";
      }
    }
    else
    {
      label324:
      if (!this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable) {
        break label585;
      }
      jdField_b_of_type_Int = paramPtvTemplateInfo.categoryId;
      jdField_b_of_type_JavaLangString = paramPtvTemplateInfo.id;
      localObject = QIMPtvTemplateManager.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.name;
      if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.kind == 3) {
        localObject = "";
      }
      if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QIMPtvTemplateManager", 2, "setVideoFilter " + (String)localObject);
        }
        this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener.a((String)localObject, false, false);
        jdField_a_of_type_JavaLangString = (String)localObject;
        i = AdvancedProviderView.b();
        this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener.c(i);
        i = AdvancedProviderView.c();
        this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener.b(i, false);
        if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.templateStyle == 0) {
          this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener.a(101, new Object[0]);
        }
      }
      localObject = (QIMPtvTemplateManager)QIMManager.a(3);
      ((QIMPtvTemplateManager)localObject).a(paramPtvTemplateInfo, 111);
      ((QIMPtvTemplateManager)localObject).a(3, paramPtvTemplateInfo.categoryId, paramPtvTemplateInfo.id);
      ((QIMPtvTemplateManager)localObject).a(113, null);
    }
    for (;;)
    {
      FlowCameraMqqAction.a("", "0X80075BA", this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id);
      if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.kind != 3) {
        break;
      }
      FlowCameraMqqAction.a("", "0X80083B9", this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id);
      return;
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener.a(null);
      break label324;
      label585:
      if ((!this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.downloading) && (!TextUtils.isEmpty(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)) && (this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager != null)) {
        if ((this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.kind == 3) && (NetworkUtil.b(this.jdField_a_of_type_AndroidContentContext)))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
            this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle("下载挂件").setMessage(this.jdField_a_of_type_AndroidContentContext.getString(2131439188)).setPositiveButton(this.jdField_a_of_type_AndroidContentContext.getString(2131432999), new amuy(this)).setNegativeButton(this.jdField_a_of_type_AndroidContentContext.getString(2131432998), new amux(this));
          }
          try
          {
            if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) || (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
              continue;
            }
            this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
          }
          catch (Throwable paramPtvTemplateInfo) {}
        }
        else
        {
          ThreadManager.postImmediately(new amuz(this), null, true);
          QIMCommonLoadingProgress.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo).a();
          ShortVideoMtaReport.a("shortvideo_download_effects", null);
        }
      }
    }
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMPtvTemplateManager", 2, "PtvTemplateAdapter selectPtvTemplateFromout");
    }
    this.d = paramInt;
    a(paramPtvTemplateInfo);
  }
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 111)
    {
      if ((paramVarArgs != null) && (paramVarArgs.length == 1))
      {
        a(((TemplateGroupItem)paramVarArgs[0]).a);
        notifyDataSetChanged();
      }
      return;
      break label65;
    }
    label65:
    do
    {
      for (;;)
      {
        if (paramInt == 112) {
          if ((paramVarArgs != null) && (paramVarArgs.length == 1))
          {
            paramObject = (PtvTemplateManager.PtvTemplateInfo)paramVarArgs[0];
            paramVarArgs = this.jdField_a_of_type_JavaUtilArrayList.iterator();
            if (paramVarArgs.hasNext())
            {
              PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)paramVarArgs.next();
              if (!paramObject.id.equals(localPtvTemplateInfo.id)) {
                break;
              }
              localPtvTemplateInfo.downloading = false;
              localPtvTemplateInfo.usable = true;
              notifyDataSetChanged();
              return;
            }
          }
        }
      }
    } while (paramInt != 113);
    notifyDataSetInvalidated();
  }
  
  public void a(List paramList)
  {
    int i = 0;
    try
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.d = 0;
      while (i < this.jdField_a_of_type_Int)
      {
        PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = new PtvTemplateManager.PtvTemplateInfo();
        localPtvTemplateInfo.id = "0";
        localPtvTemplateInfo.categoryId = 0;
        this.jdField_a_of_type_JavaUtilArrayList.add(localPtvTemplateInfo);
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      paramList = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramList.hasNext()) {
        if (((PtvTemplateManager.PtvTemplateInfo)paramList.next()).kind == 5) {
          this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$IPtvTemplateDownloadListener);
        }
      }
      return;
    }
    finally {}
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    a(paramInt);
    if ((paramView == null) || (!(paramView instanceof PtvTemplateItemView)))
    {
      paramView = new PtvTemplateItemView(this.jdField_a_of_type_AndroidContentContext);
      paramView.a();
    }
    for (;;)
    {
      paramView.a(paramInt, (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateAdapter$IPtvTemplateItemCallback, jdField_b_of_type_Int, jdField_b_of_type_JavaLangString);
      return paramView;
      paramView = (PtvTemplateItemView)paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter
 * JD-Core Version:    0.7.0.1
 */