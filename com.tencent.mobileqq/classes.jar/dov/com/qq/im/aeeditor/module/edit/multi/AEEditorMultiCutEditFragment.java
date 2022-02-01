package dov.com.qq.im.aeeditor.module.edit.multi;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelStoreOwner;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qcircle.api.IQCircleRFWApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.tav.core.composition.VideoComposition.RenderLayoutMode;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavcut.bean.CropConfig;
import com.tencent.tavcut.bean.ResInfoModel;
import com.tencent.tavcut.player.MoviePlayer;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.tavcut.session.config.SessionConfig;
import com.tencent.tavcut.util.MediaModelUtils;
import com.tencent.tavcut.util.Util;
import com.tencent.tavcut.view.TAVCutVideoView;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration.TAVVideoConfigurationContentMode;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.weishi.module.edit.cut.CutExtKt;
import com.tencent.weseevideo.camera.mvauto.redo.CutModelKt;
import com.tencent.weseevideo.camera.mvauto.redo.ResourceModel;
import com.tencent.weseevideo.camera.mvauto.redo.StoreModelConvert;
import com.tencent.weseevideo.camera.mvauto.redo.VideoResourceModelKt;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.VideoTransitionModel;
import com.tencent.weseevideo.model.resource.MediaClipModel;
import com.tencent.weseevideo.model.resource.MediaResourceModel;
import com.tencent.weseevideo.model.resource.VideoResourceModel;
import dov.com.qq.im.AEReportUtils;
import dov.com.qq.im.ae.AEViewModelProviders;
import dov.com.qq.im.ae.album.data.AEAlbumImageModel;
import dov.com.qq.im.ae.album.data.AEAlbumMediaBaseModel;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.util.AECameraPrefsUtil;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.AEEditorActivity;
import dov.com.qq.im.aeeditor.arch.AEEditorBaseFragment;
import dov.com.qq.im.aeeditor.module.clip.image.EditorPicInfo;
import dov.com.qq.im.aeeditor.module.clip.video.VideoSetSpeedDialog;
import dov.com.qq.im.aeeditor.module.edit.multi.action.ActionFactory;
import dov.com.qq.im.aeeditor.module.edit.multi.data.DataProcessor;
import dov.com.qq.im.aeeditor.module.edit.multi.viewmodel.MvVideoViewModel;
import dov.com.qq.im.aeeditor.module.params.ParamFactory;
import dov.com.qq.im.aeeditor.module.params.VideoParamStrategy;
import dov.com.qq.im.aeeditor.view.AEEditorQcircleBubbleView;
import dov.com.qq.im.aeeditor.view.dragdrop.IDragView;
import dov.com.qq.im.aeeditor.view.reorder.ReorderContainerView;
import dov.com.qq.im.aeeditor.view.reorder.ReorderListener;
import dov.com.qq.im.aeeditor.view.timebar.ScaleTimeBar;
import dov.com.qq.im.aeeditor.view.timebar.scale.ScaleAdapter;
import dov.com.qq.im.aeeditor.view.timeline.ScaleScrollLayout;
import dov.com.qq.im.aeeditor.view.videotrack.VideoTrackContainerView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public class AEEditorMultiCutEditFragment
  extends AEEditorBaseFragment
{
  private int jdField_a_of_type_Int = ScreenUtil.dip2px(73.0F);
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private MoviePlayer jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer = null;
  private TAVCutVideoSession jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession;
  private TAVCutVideoView jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView = null;
  private VideoSetSpeedDialog jdField_a_of_type_DovComQqImAeeditorModuleClipVideoVideoSetSpeedDialog;
  private MvVideoViewModel jdField_a_of_type_DovComQqImAeeditorModuleEditMultiViewmodelMvVideoViewModel;
  private VideoParamStrategy jdField_a_of_type_DovComQqImAeeditorModuleParamsVideoParamStrategy = ParamFactory.a();
  protected AEEditorQcircleBubbleView a;
  private ReorderContainerView jdField_a_of_type_DovComQqImAeeditorViewReorderReorderContainerView;
  private ReorderListener jdField_a_of_type_DovComQqImAeeditorViewReorderReorderListener = new AEEditorMultiCutEditFragment.1(this);
  private ScaleTimeBar jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleTimeBar;
  private ScaleAdapter jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleScaleAdapter;
  private ScaleScrollLayout jdField_a_of_type_DovComQqImAeeditorViewTimelineScaleScrollLayout;
  protected VideoTrackContainerView a;
  private final Runnable jdField_a_of_type_JavaLangRunnable = new AEEditorMultiCutEditFragment.9(this);
  private ArrayList<AEAlbumMediaBaseModel> jdField_a_of_type_JavaUtilArrayList;
  private List<CutModelKt> jdField_a_of_type_JavaUtilList = Collections.emptyList();
  protected boolean a;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  protected String b;
  private boolean jdField_b_of_type_Boolean = true;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  protected String c;
  private boolean jdField_c_of_type_Boolean = false;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private boolean jdField_d_of_type_Boolean;
  private boolean e = true;
  private boolean f = true;
  private boolean g = false;
  private boolean h = false;
  
  private int a(@Nullable List<CutModelKt> paramList)
  {
    if (CollectionUtils.isEmpty(paramList)) {
      return 6;
    }
    Iterator localIterator = paramList.iterator();
    paramList = null;
    long l1 = 0L;
    long l2;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        CutModelKt localCutModelKt = (CutModelKt)localIterator.next();
        if ((localCutModelKt != null) && (localCutModelKt.getResource() != null))
        {
          l2 = localCutModelKt.getResource().getScaleDuration();
          if (paramList == null) {
            paramList = Long.valueOf(l2);
          }
        }
      }
    }
    for (;;)
    {
      l1 += l2;
      break;
      if (l2 < paramList.longValue())
      {
        paramList = Long.valueOf(l2);
        continue;
        if ((paramList == null) || (l1 <= 60000L)) {
          return 6;
        }
        if (paramList.longValue() >= 5000L) {
          return 9;
        }
        if (paramList.longValue() > 2000L) {
          return 8;
        }
        return 6;
      }
    }
  }
  
  private long a()
  {
    return this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleScaleAdapter.a(getResources().getDimension(2131296301));
  }
  
  private LifecycleOwner a()
  {
    return (AEEditorActivity)getActivity();
  }
  
  private ViewModelStoreOwner a()
  {
    return (AEEditorActivity)getActivity();
  }
  
  private List<ResInfoModel> a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (AEAlbumMediaBaseModel)localIterator.next();
      if (localObject != null)
      {
        if ((localObject instanceof AEAlbumImageModel)) {}
        for (int i = 2;; i = 1)
        {
          ResInfoModel localResInfoModel = new ResInfoModel();
          localResInfoModel.setResPath(((AEAlbumMediaBaseModel)localObject).getPath());
          localResInfoModel.setType(i);
          if (i == 2)
          {
            localObject = ((AEAlbumImageModel)localObject).getEditorPicInfo();
            localResInfoModel.setCropConfig(new CropConfig((float)((EditorPicInfo)localObject).x, (float)((EditorPicInfo)localObject).y, (float)Math.min(((EditorPicInfo)localObject).w, 1.0D), (float)((EditorPicInfo)localObject).h));
          }
          localArrayList.add(localResInfoModel);
          break;
        }
      }
    }
    return localArrayList;
  }
  
  @RequiresApi(api=16)
  private void a(long paramLong)
  {
    this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleTimeBar.a(paramLong, 800);
    b(paramLong);
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView = ((TAVCutVideoView)paramView.findViewById(2131378948));
    ((ImageView)paramView.findViewById(2131369466)).setOnClickListener(new AEEditorMultiCutEditFragment.10(this));
    ((ImageView)paramView.findViewById(2131369463)).setOnClickListener(new AEEditorMultiCutEditFragment.11(this));
  }
  
  private void a(ResourceModel paramResourceModel)
  {
    Iterator localIterator = paramResourceModel.getTransitionData().iterator();
    VideoTransitionModel localVideoTransitionModel;
    float f1;
    for (int i = 0; localIterator.hasNext(); i = (int)(localVideoTransitionModel.getOverlapTime() / localVideoTransitionModel.getSpeed() + f1))
    {
      localVideoTransitionModel = (VideoTransitionModel)localIterator.next();
      f1 = i;
    }
    this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleScaleAdapter.a(paramResourceModel.getAllVideoDuration() - i);
    this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleTimeBar.a(this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleScaleAdapter);
  }
  
  @RequiresApi(api=16)
  private void a(IDragView paramIDragView)
  {
    if ((paramIDragView == null) || (((View)paramIDragView).getParent() == null)) {}
    for (;;)
    {
      return;
      long l1 = this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleScaleAdapter.c();
      long l2 = this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView.a(paramIDragView);
      long l3 = this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView.b(paramIDragView);
      if ((this.g) || (this.h) || (l2 >= l1) || (l3 <= l1))
      {
        if (this.g)
        {
          l1 = a() + l2;
          this.g = false;
          AEQLog.a("AEEditorMultiCutEditFragment", "起始点变化，滚到view的起始位置. 旧方法计算的时间：" + l2 + ". 新方法：" + l1);
        }
        while (l1 != 9223372036854775807L)
        {
          if (l1 < 0L)
          {
            AEQLog.a("AEEditorMultiCutEditFragment", "targetTime小于0，设置为0");
            l2 = 0L;
          }
          for (;;)
          {
            this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleTimeBar.a(l2, 800);
            b(l2);
            return;
            if (this.h)
            {
              l1 = l3 - a();
              this.h = false;
              AEQLog.a("AEEditorMultiCutEditFragment", "结束点变化，滚到view的结束位置. 旧方法计算的时间：" + l3 + ". 新方法:" + l1);
              break;
            }
            if ((l3 >= 0L) && (l3 <= l1))
            {
              l1 = l3 - a();
              AEQLog.a("AEEditorMultiCutEditFragment", "滑块在屏幕左边，滚到view的结束位置. 旧方法：" + l3 + ". 新方法：" + l1);
              break;
            }
            if ((l2 < 0L) || (l2 < l1)) {
              break label411;
            }
            l1 = a() + l2;
            AEQLog.a("AEEditorMultiCutEditFragment", "滑块在屏幕右边，滚到view的开始位置. 旧方法：" + l2 + ". 新方法：" + l1);
            break;
            l2 = l1;
            if (l1 > this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleScaleAdapter.b())
            {
              l2 = this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleScaleAdapter.b();
              AEQLog.a("AEEditorMultiCutEditFragment", "targetTime大于endValue，设置为endValue：" + l2);
            }
          }
          label411:
          l1 = 9223372036854775807L;
        }
      }
    }
  }
  
  private void a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      AEQLog.c("AEEditorMultiCutEditFragment", "mediaModels == null || mediaModels.size() == 0");
    }
    Iterator localIterator;
    do
    {
      return;
      while (!localIterator.hasNext()) {
        localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      }
    } while (!((AEAlbumMediaBaseModel)localIterator.next()).getOriginPath().equals(paramString));
    localIterator.remove();
  }
  
  @RequiresApi(api=16)
  private void a(String paramString, long paramLong1, long paramLong2)
  {
    long l = CutExtKt.calculateClipSeek(this.jdField_a_of_type_JavaUtilList, new LinkedList(), paramString);
    if (l >= 0L) {
      a(l);
    }
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditMultiViewmodelMvVideoViewModel.a.postValue(ActionFactory.a(paramString, paramLong1, paramLong2, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel()));
    AEBaseDataReporter.a().B();
    AEReportUtils.o();
  }
  
  @RequiresApi(api=16)
  private void a(List<MediaClipModel> paramList, boolean paramBoolean)
  {
    List localList2 = StoreModelConvert.INSTANCE.convert(paramList);
    List localList1 = localList2;
    if (MediaModelUtils.getTotalSelectDuration(paramList) >= 60000L) {
      localList1 = StoreModelConvert.INSTANCE.restoreClipTimeRange(localList2);
    }
    if (paramBoolean) {
      a(0L);
    }
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditMultiViewmodelMvVideoViewModel.a.postValue(ActionFactory.a(localList1, null));
  }
  
  private void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    CutModelKt localCutModelKt = this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView.a();
    if (localCutModelKt != null)
    {
      if (localCutModelKt.getResource().getType() == 2)
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130837914);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166284));
        if ((this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoVideoSetSpeedDialog != null) && (this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoVideoSetSpeedDialog.isShowing())) {
          this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoVideoSetSpeedDialog.dismiss();
        }
      }
      while (this.jdField_a_of_type_JavaUtilList.size() < 2)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166284));
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130837908);
        return;
        if (this.e)
        {
          this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130837913);
          this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131165357));
        }
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130837907);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131165357));
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166284));
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130837914);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130837908);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166284));
  }
  
  private List<MediaClipModel> b()
  {
    return DataProcessor.a(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  private void b(long paramLong)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditMultiViewmodelMvVideoViewModel.a(CMTime.fromMs(paramLong));
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370643));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369867));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380701));
    this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).getTypeface(getActivity(), "https://downv6.qq.com/video_story/qcircle/ttf/qircle_number_bold.ttf"));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new AEEditorMultiCutEditFragment.12(this));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131367054));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(new AEEditorMultiCutEditFragment.13(this));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369558));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131362321));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369634));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380299));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new AEEditorMultiCutEditFragment.14(this));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131362322));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380608));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369818));
    if (!getArguments().getBoolean("ae_editor_is_light_model", false)) {}
    for (boolean bool = true;; bool = false)
    {
      this.e = bool;
      if (this.e) {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new AEEditorMultiCutEditFragment.15(this));
      }
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131377156));
      this.jdField_a_of_type_DovComQqImAeeditorViewTimelineScaleScrollLayout = ((ScaleScrollLayout)paramView.findViewById(2131377468));
      this.jdField_a_of_type_DovComQqImAeeditorViewTimelineScaleScrollLayout.setOnClickListener(new AEEditorMultiCutEditFragment.16(this));
      this.jdField_a_of_type_DovComQqImAeeditorViewReorderReorderContainerView = ((ReorderContainerView)paramView.findViewById(2131376983));
      this.jdField_a_of_type_DovComQqImAeeditorViewReorderReorderContainerView.a();
      this.jdField_a_of_type_DovComQqImAeeditorViewReorderReorderContainerView.setReorderListener(this.jdField_a_of_type_DovComQqImAeeditorViewReorderReorderListener);
      this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleTimeBar = ((ScaleTimeBar)paramView.findViewById(2131378459));
      this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleTimeBar.setOnBarMoveListener(new AEEditorMultiCutEditFragment.17(this));
      this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleTimeBar.setMaxDurationLimit(60000L);
      this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleTimeBar.setMaxDurationLimitTip(getString(2131689724));
      this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView = ((VideoTrackContainerView)paramView.findViewById(2131381790));
      this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView.setScaleAdapter(this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleScaleAdapter);
      this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView.setMaxDurationLimit(60000L);
      this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView.setTimeBar(this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleTimeBar);
      this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView.setVideoModel(this.jdField_a_of_type_DovComQqImAeeditorModuleEditMultiViewmodelMvVideoViewModel);
      this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView.setScrollListener(new AEEditorMultiCutEditFragment.18(this));
      this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView.setOnStartTimeChangedListener(new AEEditorMultiCutEditFragment.19(this));
      this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView.setSelectedStateListener(new AEEditorMultiCutEditFragment.20(this));
      this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView.setOnTransitionListener(new AEEditorMultiCutEditFragment.21(this));
      this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView.setVideoTrackStoreListener(new AEEditorMultiCutEditFragment.22(this));
      this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView.setItemOnLongClickListener(new AEEditorMultiCutEditFragment.23(this));
      paramView.setOnClickListener(new AEEditorMultiCutEditFragment.24(this));
      return;
    }
  }
  
  @RequiresApi(api=17)
  private void b(ResourceModel paramResourceModel)
  {
    this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView.a(paramResourceModel.getData());
    this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView.a(paramResourceModel.getTransitionData(), paramResourceModel.getTransitionPosition());
    if (paramResourceModel.getSelectUuid() != null) {
      this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView.a(paramResourceModel.getSelectUuid(), paramResourceModel.getFlashing());
    }
    this.jdField_a_of_type_DovComQqImAeeditorViewReorderReorderContainerView.a(paramResourceModel.getData());
  }
  
  private void c(long paramLong)
  {
    if ((this.jdField_a_of_type_DovComQqImAeeditorModuleEditMultiViewmodelMvVideoViewModel == null) || (!this.jdField_a_of_type_DovComQqImAeeditorModuleEditMultiViewmodelMvVideoViewModel.a())) {}
    do
    {
      return;
      if (this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleTimeBar != null) {
        this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleTimeBar.a(paramLong / 1000L);
      }
    } while (this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView == null);
    this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView.c();
  }
  
  private boolean c()
  {
    return (this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals("AEEditorMultiVideoEdit"));
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer != null) && (!this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.isPlaying())) {
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.play();
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer != null) && (this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.isPlaying())) {
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.pause();
    }
  }
  
  @RequiresApi(api=16)
  private void f()
  {
    try
    {
      MediaResourceModel localMediaResourceModel = ((MediaResourceModel)getArguments().getSerializable("resource_model")).deepCopy();
      if (localMediaResourceModel != null)
      {
        this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().setMediaResourceModel(localMediaResourceModel);
        a(localMediaResourceModel.getVideos(), true);
        this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.updateTemplateComposition(true);
        this.jdField_c_of_type_JavaLangString = Util.md5(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().toString());
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Object localObject = null;
      }
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleScaleAdapter = new ScaleAdapter();
    this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleScaleAdapter.a(ViewUtils.a(30.0F));
    this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleScaleAdapter.b(ViewUtils.a(20.0F));
  }
  
  private void h()
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditMultiViewmodelMvVideoViewModel = ((MvVideoViewModel)AEViewModelProviders.a(a()).get(MvVideoViewModel.class));
  }
  
  @RequiresApi(api=16)
  private void i()
  {
    Object localObject1 = getArguments();
    if ((localObject1 != null) && (((Bundle)localObject1).containsKey("ae_album_selected_media_models"))) {
      this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)((Bundle)localObject1).getSerializable("ae_album_selected_media_models"));
    }
    StringBuilder localStringBuilder = new StringBuilder().append("passed in media models, size=");
    int i;
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      i = 0;
    }
    for (;;)
    {
      AEQLog.a("AEEditorMultiCutEditFragment", i);
      this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleTimeBar.setScaleAdapter(this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleScaleAdapter);
      this.jdField_a_of_type_DovComQqImAeeditorModuleEditMultiViewmodelMvVideoViewModel.a.observe(a(), new AEEditorMultiCutEditFragment.6(this));
      if ((localObject1 != null) && (((Bundle)localObject1).containsKey("resource_model"))) {
        try
        {
          localObject1 = ((MediaResourceModel)getArguments().getSerializable("resource_model")).deepCopy();
          if (localObject1 != null) {
            a(((MediaResourceModel)localObject1).getVideos(), true);
          }
          return;
          i = this.jdField_a_of_type_JavaUtilArrayList.size();
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            Object localObject2 = null;
          }
        }
      }
    }
    a(b(), false);
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer != null)
    {
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.release();
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer = null;
    }
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer = new MoviePlayer();
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.setLoopPlay(true);
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.setBackColor(getResources().getColor(2131165216));
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.addPlayerListener(new AEEditorMultiCutEditFragment.7(this));
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null)
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.release();
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession = null;
    }
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession = new TAVCutVideoSession();
    SessionConfig localSessionConfig = new SessionConfig();
    localSessionConfig.setContentMode(TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
    localSessionConfig.setRenderLayoutMode(VideoComposition.RenderLayoutMode.aspectFit);
    localSessionConfig.setMaxIntermediateRenderSize(this.jdField_a_of_type_DovComQqImAeeditorModuleParamsVideoParamStrategy.a());
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setSessionConfig(localSessionConfig);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.addPlayer(this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setTAVCutVideoView(this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.initMultiCutSession(getActivity(), a());
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setTemplate(2, "assets://camera/template", true, new String[] { "template.json" });
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleEditMultiViewmodelMvVideoViewModel != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleEditMultiViewmodelMvVideoViewModel.a(this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer);
    }
    this.jdField_b_of_type_JavaLangString = Util.md5(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().toString());
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorQcircleBubbleView == null) {
      this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorQcircleBubbleView = new AEEditorQcircleBubbleView(getActivity());
    }
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.post(new AEEditorMultiCutEditFragment.8(this));
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoVideoSetSpeedDialog == null)
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoVideoSetSpeedDialog = new VideoSetSpeedDialog(getActivity(), 2131755194);
      this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoVideoSetSpeedDialog.c(83);
      this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoVideoSetSpeedDialog.b(DisplayUtil.b(getActivity(), 60.0F));
      this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoVideoSetSpeedDialog.a(DisplayUtil.b(getActivity(), 42.0F));
      this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoVideoSetSpeedDialog.a(new AEEditorMultiCutEditFragment.25(this));
    }
    this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoVideoSetSpeedDialog.show();
    if (this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView != null)
    {
      CutModelKt localCutModelKt = this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView.a();
      if ((localCutModelKt != null) && (localCutModelKt.getResource() != null)) {
        this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoVideoSetSpeedDialog.a(localCutModelKt.getResource().getScaleSpeed());
      }
    }
  }
  
  public String a()
  {
    return "AEEditorMultiCutFragment";
  }
  
  @RequiresApi(api=16)
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AEQLog.b("AEEditorMultiCutEditFragment", "doOnActivityResult---requestCode=" + paramInt1 + ", resultCode=" + paramInt2);
    if ((paramInt1 == 1024) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getSerializableExtra("ae_album_selected_media_models");
      if (paramIntent == null) {
        AEQLog.a("AEEditorMultiCutEditFragment", "serializableExtra == null");
      }
    }
    else
    {
      return;
    }
    Object localObject = (ArrayList)paramIntent;
    AEQLog.a("AEEditorMultiCutEditFragment", "ADDITIONAL passed in media models, size=" + ((ArrayList)localObject).size());
    if (((ArrayList)localObject).size() == 0)
    {
      AEQLog.a("AEEditorMultiCutEditFragment", "addMediaModels.size() == 0");
      return;
    }
    if (this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView == null)
    {
      AEQLog.a("AEEditorMultiCutEditFragment", "mVideoTrackContainer == null");
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject);
    paramInt2 = this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView.b();
    paramIntent = DataProcessor.a((List)localObject);
    localObject = DataProcessor.b((List)localObject);
    paramIntent = StoreModelConvert.INSTANCE.convert(paramIntent);
    paramIntent = ActionFactory.a(paramInt2, this.jdField_a_of_type_JavaUtilList, paramIntent, (List)localObject, this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel());
    if (MediaModelUtils.getTotalSelectDuration(paramIntent.getMediaClipModel()) >= 60000L)
    {
      localObject = StoreModelConvert.INSTANCE.restoreClipTimeRange(paramIntent.getData());
      paramIntent = new ResourceModel(paramIntent.getSelectUuid(), paramIntent.getFlashing(), (List)localObject, paramIntent.getBackupData(), paramIntent.getTransitionData(), paramIntent.getTransitionPosition(), paramIntent.getSmartCutType());
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleEditMultiViewmodelMvVideoViewModel.a.setValue(paramIntent);
      long l = 0L;
      paramInt1 = 0;
      while (paramInt1 <= paramInt2)
      {
        l += ((MediaClipModel)paramIntent.getMediaClipModel().get(paramInt1)).getResource().getScaleDuration();
        paramInt1 += 1;
      }
      a(l);
      return;
    }
  }
  
  public boolean a()
  {
    int i;
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_JavaLangString.equals(Util.md5(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().toString())))) {
      i = 0;
    }
    for (;;)
    {
      if (i == 0)
      {
        return false;
        if ((this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (this.jdField_c_of_type_JavaLangString.equals(Util.md5(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().toString())))) {
          i = 0;
        }
      }
      else
      {
        Object localObject = getActivity();
        localObject = DialogUtil.a((Context)localObject, 230).setTitle(HardCodeUtil.a(2131689758)).setMessage(((Context)localObject).getString(2131689759)).setPositiveButton(((Context)localObject).getString(2131689715), new AEEditorMultiCutEditFragment.5(this)).setNegativeButton(((Context)localObject).getString(2131689713), new AEEditorMultiCutEditFragment.4(this));
        if (localObject != null) {}
        try
        {
          if (!((QQCustomDialog)localObject).isShowing()) {
            ((QQCustomDialog)localObject).show();
          }
          return true;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            localThrowable.printStackTrace();
          }
        }
      }
      i = 1;
    }
  }
  
  protected boolean b()
  {
    return AECameraPrefsUtil.a().a("SP_KEY_FIRST_ENTER_VIDEO_CUT", true, 0);
  }
  
  protected void c()
  {
    AECameraPrefsUtil.a().a("SP_KEY_FIRST_ENTER_VIDEO_CUT", false, 0);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_c_of_type_Boolean = true;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    g();
    h();
    paramLayoutInflater = paramLayoutInflater.inflate(2131558592, paramViewGroup, false);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_c_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null) {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.release();
    }
    if (this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer != null)
    {
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.release();
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer = null;
    }
  }
  
  @RequiresApi(api=16)
  public void onHiddenChanged(boolean paramBoolean)
  {
    boolean bool = true;
    super.onHiddenChanged(paramBoolean);
    this.jdField_d_of_type_Boolean = paramBoolean;
    if (!paramBoolean)
    {
      if (!c())
      {
        paramBoolean = true;
        this.jdField_a_of_type_Boolean = paramBoolean;
        f();
        if (this.jdField_c_of_type_Boolean) {
          d();
        }
        if (getArguments().getBoolean("ae_editor_is_light_model", false)) {
          break label100;
        }
        paramBoolean = bool;
        label61:
        this.e = paramBoolean;
        if (!this.e) {
          break label105;
        }
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new AEEditorMultiCutEditFragment.2(this));
      }
      for (;;)
      {
        AEBaseDataReporter.a().y();
        return;
        paramBoolean = false;
        break;
        label100:
        paramBoolean = false;
        break label61;
        label105:
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new AEEditorMultiCutEditFragment.3(this));
      }
    }
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.onPause();
    e();
  }
  
  public void onPause()
  {
    super.onPause();
    if (!this.jdField_d_of_type_Boolean) {
      e();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (!this.jdField_d_of_type_Boolean)
    {
      if (this.jdField_b_of_type_Boolean) {
        d();
      }
      AEBaseDataReporter.a().y();
      AEReportUtils.k();
    }
  }
  
  @RequiresApi(api=16)
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a(paramView);
    b(paramView);
    i();
    j();
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment
 * JD-Core Version:    0.7.0.1
 */