package dov.com.qq.im.ae.album.logic;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListData;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.ProgressPieDrawable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.tav.decoder.EncoderWriter.OutputConfig;
import com.tencent.tavcut.bean.Size;
import com.tencent.tavcut.exporter.MovieExporter;
import com.tencent.tavcut.exporter.MovieExporter.VideoCompressListener;
import com.tencent.tavcut.util.VideoUtil;
import com.tencent.usq.u;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import dov.com.qq.im.AEReportUtils;
import dov.com.qq.im.ae.album.data.AEAlbumLogicData;
import dov.com.qq.im.ae.album.fragment.AEAbstractPhotoListFragment.PhotoGridAdapter;
import dov.com.qq.im.ae.album.fragment.AEAbstractPhotoListFragment.PhotoVH;
import dov.com.qq.im.ae.album.fragment.AENewPhotoListFragment;
import dov.com.qq.im.ae.camera.ui.watermark.WatermarkDataManager;
import dov.com.qq.im.ae.entry.AECameraEntry;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.AEEditorPath.EDITOR.CACHE;
import dov.com.qq.im.aeeditor.module.params.ParamFactory;
import dov.com.qq.im.aeeditor.module.params.VideoParamStrategy;
import dov.com.qq.im.aeeditor.util.AEEditorJumpUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

public class AEPhotoListLogicAECircle
  extends AEPhotoListLogicDefault
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "video/mp4", "video/3gpp" };
  private int jdField_a_of_type_Int = 0;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private ProgressPieDrawable jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable;
  private MovieExporter jdField_a_of_type_ComTencentTavcutExporterMovieExporter;
  private int jdField_b_of_type_Int = 3000;
  private Dialog jdField_b_of_type_AndroidAppDialog;
  private boolean jdField_b_of_type_Boolean = false;
  private int c = 3000;
  
  public AEPhotoListLogicAECircle(AENewPhotoListFragment paramAENewPhotoListFragment)
  {
    super(paramAENewPhotoListFragment);
    AEQLog.a("PhotoListLogicAECircle", "[AE Profiler] PhotoListLogicAECircle new");
  }
  
  private ProgressPieDrawable a()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() == null) {
      return null;
    }
    ProgressPieDrawable localProgressPieDrawable = new ProgressPieDrawable(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity());
    localProgressPieDrawable.a(AIOUtils.a(50.0F, ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getResources()));
    localProgressPieDrawable.a(true);
    localProgressPieDrawable.c(false);
    localProgressPieDrawable.g(-1);
    localProgressPieDrawable.f(0);
    localProgressPieDrawable.d(-15550475);
    localProgressPieDrawable.i(3);
    localProgressPieDrawable.jdField_f_of_type_Boolean = true;
    localProgressPieDrawable.jdField_f_of_type_Int = 2;
    localProgressPieDrawable.e(true);
    localProgressPieDrawable.c(0);
    localProgressPieDrawable.a(new AEPhotoListLogicAECircle.5(this));
    return localProgressPieDrawable;
  }
  
  private EncoderWriter.OutputConfig a(LocalMediaInfo paramLocalMediaInfo)
  {
    if (paramLocalMediaInfo == null) {
      return null;
    }
    EncoderWriter.OutputConfig localOutputConfig = new EncoderWriter.OutputConfig();
    VideoParamStrategy localVideoParamStrategy = ParamFactory.a();
    paramLocalMediaInfo = localVideoParamStrategy.a(VideoUtil.getVideoSize(paramLocalMediaInfo.path));
    localOutputConfig.VIDEO_BIT_RATE = localVideoParamStrategy.b();
    localOutputConfig.VIDEO_TARGET_HEIGHT = paramLocalMediaInfo.getHeight();
    localOutputConfig.VIDEO_TARGET_WIDTH = paramLocalMediaInfo.getWidth();
    return localOutputConfig;
  }
  
  private void a(int paramInt, LocalMediaInfo paramLocalMediaInfo)
  {
    c(true);
    a(paramLocalMediaInfo, new AEPhotoListLogicAECircle.3(this, System.currentTimeMillis(), paramLocalMediaInfo, paramInt));
  }
  
  private boolean a(LocalMediaInfo paramLocalMediaInfo, int paramInt1, int paramInt2)
  {
    if (paramInt2 != 1) {
      if (this.jdField_a_of_type_Int == 1)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() == 1)
        {
          if (paramInt1 == 0) {
            QQToast.a(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), HardCodeUtil.a(2131689798), 0).b(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
          }
          return true;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() == 0) {
          if (paramInt1 == 0) {
            this.jdField_a_of_type_Int = 0;
          }
        }
      }
    }
    for (;;)
    {
      return false;
      AEQLog.d("PhotoListLogicAECircle", "[error] size > 1 && mDataType = video");
      continue;
      if (this.jdField_a_of_type_Int == 0)
      {
        if (paramInt1 == 0)
        {
          if (((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(paramLocalMediaInfo))
          {
            QQToast.a(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), HardCodeUtil.a(2131689796), 0).b(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
            return true;
          }
          if ((paramLocalMediaInfo.mediaWidth < 20) || (paramLocalMediaInfo.mediaHeight < 20))
          {
            QQToast.a(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), HardCodeUtil.a(2131689790), 0).b(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
            return true;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() + this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.initialHasPickedNum >= this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum)
          {
            paramLocalMediaInfo = BaseApplicationImpl.sApplication.getResources().getString(2131689797, new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum) });
            QQToast.a(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), paramLocalMediaInfo, 0).b(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
            return true;
          }
        }
      }
      else
      {
        AEQLog.d("PhotoListLogicAECircle", "[error] no know mDataType~");
        continue;
        if (this.jdField_a_of_type_Int == 1) {
          this.jdField_a_of_type_Int = 0;
        } else if (this.jdField_a_of_type_Int != 0) {
          AEQLog.d("PhotoListLogicAECircle", "[error] no know mDataType~");
        }
      }
    }
  }
  
  private boolean a(String paramString, long paramLong)
  {
    try
    {
      MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
      localMediaMetadataRetriever.setDataSource(paramString);
      long l1 = Long.parseLong(localMediaMetadataRetriever.extractMetadata(20));
      long l2 = Long.parseLong(localMediaMetadataRetriever.extractMetadata(18));
      long l3 = Long.parseLong(localMediaMetadataRetriever.extractMetadata(19));
      long l4 = Long.parseLong(localMediaMetadataRetriever.extractMetadata(9));
      long l5 = FileUtils.a(paramString);
      AEQLog.d("PhotoListLogicAECircle", "compress finish!\n outputPath: " + paramString + "\n outputDuring: " + l4 + "\n outputWidth: " + l2 + "\n outputHeight: " + l3 + "\n outputBitrate: " + l1 + "\n outputSize: " + l5 + " bytes");
      if ((l4 > 1000L + paramLong) || (l4 < paramLong - 1000L))
      {
        AEQLog.d("PhotoListLogicAECircle", "[checkVideoIsOK] time error");
        return false;
      }
    }
    catch (NumberFormatException paramString)
    {
      AEQLog.d("PhotoListLogicAECircle", "[checkVideoIsOK] NumberFormatException");
      return false;
    }
    catch (IllegalArgumentException paramString)
    {
      AEQLog.d("PhotoListLogicAECircle", "[checkVideoIsOK] IllegalArgumentException");
      return false;
    }
    return true;
  }
  
  @NotNull
  private String b(LocalMediaInfo paramLocalMediaInfo)
  {
    Object localObject = u.a(paramLocalMediaInfo.path);
    String str = "";
    if (!StringUtil.a((String)localObject)) {
      paramLocalMediaInfo = (String)localObject + ".mp4";
    }
    for (;;)
    {
      return AEEditorPath.EDITOR.CACHE.b + File.separator + paramLocalMediaInfo;
      localObject = paramLocalMediaInfo.path.split("/");
      paramLocalMediaInfo = str;
      if (localObject.length > 0) {
        paramLocalMediaInfo = localObject[(localObject.length - 1)];
      }
    }
  }
  
  private void b(int paramInt)
  {
    boolean bool = false;
    if (this.jdField_b_of_type_AndroidAppDialog != null) {
      return;
    }
    LocalMediaInfo localLocalMediaInfo;
    int i;
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() == 0) && (this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.canPickVideo))
    {
      localLocalMediaInfo = ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumFragmentAEAbstractPhotoListFragment$PhotoGridAdapter.a(paramInt);
      i = a(localLocalMediaInfo);
      switch (i)
      {
      case 1: 
      default: 
        d(i);
        return;
      case 0: 
        this.jdField_a_of_type_Int = 1;
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.add(localLocalMediaInfo.path);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.add(Integer.valueOf(paramInt));
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.put(localLocalMediaInfo.path, localLocalMediaInfo);
        localObject = (LinkedHashMap)AlbumUtil.sSelectItemPosMap.get(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId);
        if (localObject == null)
        {
          localObject = new LinkedHashMap();
          AlbumUtil.sSelectItemPosMap.put(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, localObject);
        }
        break;
      }
    }
    for (;;)
    {
      ((LinkedHashMap)localObject).put(localLocalMediaInfo.path, Integer.valueOf(((GridLayoutManager)((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager()).findFirstVisibleItemPosition()));
      localObject = AlbumUtil.sSelectItemAlbum;
      if (!((HashMap)localObject).containsKey(localLocalMediaInfo.path))
      {
        Pair localPair = new Pair(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName);
        ((HashMap)localObject).put(localLocalMediaInfo.path, localPair);
      }
      if (Build.VERSION.SDK_INT >= 23) {
        if (((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
          i = 1;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          AEQLog.b("PhotoListLogicAECircle", "updateWMProps onGetLocation");
          WatermarkDataManager.a().a(new AEPhotoListLogicAECircle.1(this));
        }
        k();
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.clear();
        if (this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.initialHasPickedNum > 0) {
          bool = true;
        }
        AEReportUtils.a(bool, true, 1, paramInt);
        return;
        i = 0;
        continue;
        try
        {
          a(paramInt, localLocalMediaInfo);
          return;
        }
        catch (Exception localException)
        {
          AEQLog.d("PhotoListLogicAECircle", localException.toString());
          c(false);
          QQToast.a(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), HardCodeUtil.a(2131689800), 0).b(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
          return;
        }
        QQToast.a(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), HardCodeUtil.a(2131689798), 0).b(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
        return;
        i = 1;
      }
    }
  }
  
  private void c(int paramInt)
  {
    int i = a(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumFragmentAEAbstractPhotoListFragment$PhotoGridAdapter.a(paramInt));
    switch (i)
    {
    case 1: 
    default: 
      d(i);
      return;
    }
    a(paramInt, (AEAbstractPhotoListFragment.PhotoVH)((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForAdapterPosition(paramInt));
  }
  
  private void c(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference.get() != null) && (((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity() != null) && (!((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().isFinishing()))
    {
      if (!paramBoolean) {
        break label180;
      }
      if ((this.jdField_b_of_type_AndroidAppDialog == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable == null))
      {
        this.jdField_b_of_type_AndroidAppDialog = new ReportDialog(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 2131755842);
        this.jdField_b_of_type_AndroidAppDialog.setCancelable(false);
        this.jdField_b_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
        this.jdField_b_of_type_AndroidAppDialog.setContentView(2131558602);
        localImageView = (ImageView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131369625);
        localButton = (Button)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131363941);
        this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable = a();
        localImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable);
        localButton.setOnClickListener(new AEPhotoListLogicAECircle.4(this));
      }
      this.jdField_b_of_type_AndroidAppDialog.show();
    }
    label180:
    while ((this.jdField_b_of_type_AndroidAppDialog == null) || (!this.jdField_b_of_type_AndroidAppDialog.isShowing()))
    {
      ImageView localImageView;
      Button localButton;
      return;
    }
    this.jdField_b_of_type_AndroidAppDialog.dismiss();
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable = null;
    this.jdField_b_of_type_AndroidAppDialog = null;
  }
  
  private void d(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    case 1: 
      QQToast.a(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), "请选择2秒到1小时之间的视频", 0).b(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
      return;
    case 3: 
      QQToast.a(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), HardCodeUtil.a(2131689801), 0).b(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
      return;
    case 4: 
      QQToast.a(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), HardCodeUtil.a(2131689799), 0).b(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
      return;
    }
    QQToast.a(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), HardCodeUtil.a(2131689802), 0).b(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).d);
  }
  
  private void d(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference.get() != null) && (!((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().isFinishing()))
    {
      if (!paramBoolean) {
        break label101;
      }
      if (this.jdField_a_of_type_AndroidAppDialog == null)
      {
        this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 2131755842);
        this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
        this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
        this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559683);
      }
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
    label101:
    while ((this.jdField_a_of_type_AndroidAppDialog == null) || (!this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      return;
    }
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
  }
  
  private void k()
  {
    AEEditorJumpUtil.a(this.jdField_a_of_type_Int, ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData, true);
    d(false);
  }
  
  protected int a(LocalMediaInfo paramLocalMediaInfo)
  {
    long l = paramLocalMediaInfo.mDuration;
    if ((l > 3600000L) || (l < 2000L)) {
      return 1;
    }
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    try
    {
      localMediaMetadataRetriever.setDataSource(paramLocalMediaInfo.path);
      int j = Integer.parseInt(localMediaMetadataRetriever.extractMetadata(19));
      int i = Integer.parseInt(localMediaMetadataRetriever.extractMetadata(18));
      paramLocalMediaInfo = localMediaMetadataRetriever.extractMetadata(12);
      if (j <= this.c)
      {
        j = this.jdField_b_of_type_Int;
        if (i <= j) {}
      }
      else
      {
        return 2;
      }
      if (!paramLocalMediaInfo.equals(jdField_a_of_type_ArrayOfJavaLangString[0]))
      {
        boolean bool = paramLocalMediaInfo.equals(jdField_a_of_type_ArrayOfJavaLangString[1]);
        if (!bool) {
          return 3;
        }
      }
      return 0;
    }
    catch (Exception paramLocalMediaInfo)
    {
      if (QLog.isColorLevel()) {
        paramLocalMediaInfo.printStackTrace();
      }
      return 5;
    }
    finally
    {
      localMediaMetadataRetriever.release();
    }
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    paramIntent = ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().getStringExtra("albumName");
    String str = ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().getStringExtra("albumId");
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramIntent)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName = paramIntent;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId = str;
    }
    this.jdField_b_of_type_Int = 3000;
    this.c = 3000;
  }
  
  public void a(View paramView)
  {
    AlbumUtil.clearSelectItemInfo();
    AlbumUtil.a();
    paramView = PresendPicMgr.a();
    if (paramView != null) {
      paramView.a(1006);
    }
    paramView = ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent();
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null)
    {
      i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size();
      StatisticConstants.b(paramView, i);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.i) {
        break label128;
      }
      ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().finish();
      AlbumUtil.anim(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), false, false);
      AEBaseDataReporter.a().b(System.currentTimeMillis() - this.jdField_a_of_type_Long);
    }
    label128:
    String str1;
    String str2;
    do
    {
      return;
      i = 0;
      break;
      paramView = ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent();
      str1 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      str2 = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
    } while (str1 == null);
    paramView.setClassName(str2, str1);
    paramView.removeExtra("PhotoConst.PHOTO_PATHS");
    paramView.removeExtra("PhotoConst.SINGLE_PHOTO_PATH");
    paramView.addFlags(603979776);
    if (!paramView.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false)) {
      ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivity(paramView);
    }
    for (;;)
    {
      ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().finish();
      AlbumUtil.anim(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), false, false);
      break;
      paramView.getStringExtra("PhotoConst.PLUGIN_NAME");
      str2 = paramView.getStringExtra("PhotoConst.PLUGIN_APK");
      String str3 = paramView.getStringExtra("PhotoConst.UIN");
      if ("qzone_plugin.apk".equals(str2))
      {
        QzonePluginProxyActivity.setActivityNameToIntent(paramView, str1);
        QZoneHelper.launchQZone(((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), str3, paramView, 2);
      }
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.canMixPhotoAndVideo)
    {
      c(paramInt);
      return;
    }
    b(paramInt);
  }
  
  public void a(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    LocalMediaInfo localLocalMediaInfo = ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeAlbumFragmentAEAbstractPhotoListFragment$PhotoGridAdapter.a(paramInt);
    int i = AlbumUtil.getMediaType(localLocalMediaInfo);
    int j = localLocalMediaInfo.selectStatus;
    if ((!this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.canMixPhotoAndVideo) && (a(localLocalMediaInfo, i, j))) {
      return;
    }
    super.a(paramView, paramInt, paramCheckBox);
  }
  
  protected void a(LocalMediaInfo paramLocalMediaInfo, MovieExporter.VideoCompressListener paramVideoCompressListener)
  {
    if (this.jdField_a_of_type_ComTencentTavcutExporterMovieExporter != null) {
      this.jdField_a_of_type_ComTencentTavcutExporterMovieExporter.cancelCompress();
    }
    this.jdField_a_of_type_ComTencentTavcutExporterMovieExporter = new MovieExporter();
    String str = b(paramLocalMediaInfo);
    EncoderWriter.OutputConfig localOutputConfig = a(paramLocalMediaInfo);
    this.jdField_a_of_type_ComTencentTavcutExporterMovieExporter.compressVideo(paramLocalMediaInfo.path, str, localOutputConfig, new AEPhotoListLogicAECircle.2(this, paramVideoCompressListener, str));
  }
  
  public boolean a(List<LocalMediaInfo> paramList, boolean paramBoolean)
  {
    paramBoolean = super.a(paramList, paramBoolean);
    long l2;
    long l1;
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      paramList = (AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if ((paramList != null) && (paramList.getActivity() != null))
      {
        paramList = paramList.getActivity().getIntent();
        if (AECameraEntry.k(paramList))
        {
          l2 = System.currentTimeMillis();
          l1 = l2 - paramList.getLongExtra("PhotoConst.timestamp", 0L);
          l2 -= paramList.getLongExtra("PhotoConst.timestamp_last_activity", 0L);
          if ((l1 <= 60000L) && (l2 <= 60000L) && (l1 >= 0L) && (l2 >= 0L)) {
            break label118;
          }
        }
      }
    }
    return paramBoolean;
    label118:
    AEBaseDataReporter.a().a(l1, l2);
    return paramBoolean;
  }
  
  protected boolean b()
  {
    return this.jdField_b_of_type_AndroidAppDialog != null;
  }
  
  public void c(View paramView)
  {
    k();
  }
  
  protected void e()
  {
    super.e();
    String str = ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131716930);
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size();
    int j = this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.initialHasPickedNum + i;
    if (j != 0) {
      str = str + "(" + j + ")";
    }
    for (;;)
    {
      ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).c.setText(str);
      if (this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.canMixPhotoAndVideo) {}
      for (i = this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.minSelectNumForMix; j < i; i = this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.minSelectNumForNormal)
      {
        ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).c.setEnabled(false);
        return;
      }
      ((AENewPhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).c.setEnabled(true);
      return;
    }
  }
  
  protected void i()
  {
    if (this.jdField_a_of_type_ComTencentTavcutExporterMovieExporter != null) {
      this.jdField_a_of_type_ComTencentTavcutExporterMovieExporter.cancelCompress();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.album.logic.AEPhotoListLogicAECircle
 * JD-Core Version:    0.7.0.1
 */