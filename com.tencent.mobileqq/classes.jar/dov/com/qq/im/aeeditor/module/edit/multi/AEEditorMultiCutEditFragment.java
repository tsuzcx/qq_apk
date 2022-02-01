package dov.com.qq.im.aeeditor.module.edit.multi;

import amtj;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelStoreOwner;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import bfur;
import blks;
import bmbc;
import bmbx;
import bmhk;
import bmjc;
import bmje;
import bmjf;
import bmjg;
import bmjh;
import bmji;
import bmjj;
import bmjk;
import bmjl;
import bmjm;
import bmjn;
import bmjo;
import bmjp;
import bmjq;
import bmjr;
import bmjs;
import bmjt;
import bmju;
import bmjv;
import bmjw;
import bmkc;
import bmkd;
import bmke;
import bmkf;
import bmme;
import bmmg;
import bmod;
import bmom;
import bmoz;
import bnnl;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
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
import dov.com.qq.im.ae.album.data.AEAlbumImageModel;
import dov.com.qq.im.ae.album.data.AEAlbumMediaBaseModel;
import dov.com.qq.im.aeeditor.AEEditorActivity;
import dov.com.qq.im.aeeditor.arch.AEEditorBaseFragment;
import dov.com.qq.im.aeeditor.module.clip.image.EditorPicInfo;
import dov.com.qq.im.aeeditor.module.topbar.AEEditorTopBar;
import dov.com.qq.im.aeeditor.view.reorder.ReorderContainerView;
import dov.com.qq.im.aeeditor.view.timebar.ScaleTimeBar;
import dov.com.qq.im.aeeditor.view.timeline.ScaleScrollLayout;
import dov.com.qq.im.aeeditor.view.videotrack.VideoTrackContainerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.jetbrains.annotations.Nullable;
import zau;

public class AEEditorMultiCutEditFragment
  extends AEEditorBaseFragment
{
  private int jdField_a_of_type_Int = ScreenUtil.dip2px(73.0F);
  private SpannableStringBuilder jdField_a_of_type_AndroidTextSpannableStringBuilder;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bmhk jdField_a_of_type_Bmhk;
  private bmkf jdField_a_of_type_Bmkf;
  private bmmg jdField_a_of_type_Bmmg = bmme.a();
  private bmom jdField_a_of_type_Bmom = new bmjc(this);
  private bmoz jdField_a_of_type_Bmoz;
  private MoviePlayer jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer;
  private TAVCutVideoSession jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession;
  private TAVCutVideoView jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView;
  private AEEditorTopBar jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar;
  private ReorderContainerView jdField_a_of_type_DovComQqImAeeditorViewReorderReorderContainerView;
  private ScaleTimeBar jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleTimeBar;
  private ScaleScrollLayout jdField_a_of_type_DovComQqImAeeditorViewTimelineScaleScrollLayout;
  public VideoTrackContainerView a;
  private ArrayList<AEAlbumMediaBaseModel> jdField_a_of_type_JavaUtilArrayList;
  private List<CutModelKt> jdField_a_of_type_JavaUtilList = Collections.emptyList();
  protected boolean a;
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  protected String b;
  private boolean jdField_b_of_type_Boolean = true;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  protected String c;
  private boolean jdField_c_of_type_Boolean;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private boolean jdField_d_of_type_Boolean;
  private boolean e = true;
  private boolean f;
  private boolean g;
  
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
    return this.jdField_a_of_type_Bmoz.a(getResources().getDimension(2131296284));
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
            localResInfoModel.setCropConfig(new CropConfig((float)((EditorPicInfo)localObject).x, (float)((EditorPicInfo)localObject).y, (float)((EditorPicInfo)localObject).w, (float)((EditorPicInfo)localObject).h));
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
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar = ((AEEditorTopBar)paramView.findViewById(2131378924));
    this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView = ((TAVCutVideoView)paramView.findViewById(2131378229));
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.setTopBarClickListener(new bmjt(this));
  }
  
  @RequiresApi(api=16)
  private void a(bmod parambmod)
  {
    if ((parambmod == null) || (((View)parambmod).getParent() == null)) {}
    for (;;)
    {
      return;
      long l1 = this.jdField_a_of_type_Bmoz.c();
      long l2 = this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView.a(parambmod);
      long l3 = this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView.b(parambmod);
      if ((this.f) || (this.g) || (l2 >= l1) || (l3 <= l1))
      {
        if (this.f)
        {
          l1 = a() + l2;
          this.f = false;
          bmbx.a("AEEditorMultiCutEditFragment", "起始点变化，滚到view的起始位置. 旧方法计算的时间：" + l2 + ". 新方法：" + l1);
        }
        while (l1 != 9223372036854775807L)
        {
          if (l1 < 0L)
          {
            bmbx.a("AEEditorMultiCutEditFragment", "targetTime小于0，设置为0");
            l2 = 0L;
          }
          for (;;)
          {
            this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleTimeBar.a(l2, 800);
            b(l2);
            return;
            if (this.g)
            {
              l1 = l3 - a();
              this.g = false;
              bmbx.a("AEEditorMultiCutEditFragment", "结束点变化，滚到view的结束位置. 旧方法计算的时间：" + l3 + ". 新方法:" + l1);
              break;
            }
            if ((l3 >= 0L) && (l3 <= l1))
            {
              l1 = l3 - a();
              bmbx.a("AEEditorMultiCutEditFragment", "滑块在屏幕左边，滚到view的结束位置. 旧方法：" + l3 + ". 新方法：" + l1);
              break;
            }
            if ((l2 < 0L) || (l2 < l1)) {
              break label411;
            }
            l1 = a() + l2;
            bmbx.a("AEEditorMultiCutEditFragment", "滑块在屏幕右边，滚到view的开始位置. 旧方法：" + l2 + ". 新方法：" + l1);
            break;
            l2 = l1;
            if (l1 > this.jdField_a_of_type_Bmoz.b())
            {
              l2 = this.jdField_a_of_type_Bmoz.b();
              bmbx.a("AEEditorMultiCutEditFragment", "targetTime大于endValue，设置为endValue：" + l2);
            }
          }
          label411:
          l1 = 9223372036854775807L;
        }
      }
    }
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
    this.jdField_a_of_type_Bmoz.a(paramResourceModel.getAllVideoDuration() - i);
    this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleTimeBar.a(this.jdField_a_of_type_Bmoz);
  }
  
  @RequiresApi(api=16)
  private void a(String paramString, long paramLong1, long paramLong2)
  {
    long l = CutExtKt.calculateClipSeek(this.jdField_a_of_type_JavaUtilList, new LinkedList(), paramString);
    if (l >= 0L) {
      a(l);
    }
    this.jdField_a_of_type_Bmkf.a.postValue(bmkc.a(paramString, paramLong1, paramLong2, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel()));
    bmbc.a().D();
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
    this.jdField_a_of_type_Bmkf.a.postValue(bmkc.a(localList1, null));
  }
  
  private void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    }
    for (;;)
    {
      return;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      CutModelKt localCutModelKt = this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView.a();
      if (localCutModelKt != null)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        if (localCutModelKt.getResource().getType() == 2)
        {
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          if ((this.jdField_a_of_type_Bmhk != null) && (this.jdField_a_of_type_Bmhk.isShowing())) {
            this.jdField_a_of_type_Bmhk.dismiss();
          }
        }
        else
        {
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          if (bmke.a(localCutModelKt.getResource().getScaleSpeed(), 1.0F))
          {
            this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130837752);
            return;
          }
          this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130837753);
        }
      }
      else
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        if (this.jdField_a_of_type_Bmoz.b() > 60000L)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          k();
          this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidTextSpannableStringBuilder);
        }
        while ((this.jdField_a_of_type_Bmhk != null) && (this.jdField_a_of_type_Bmhk.isShowing()))
        {
          this.jdField_a_of_type_Bmhk.dismiss();
          return;
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetTextView.setText(2131689698);
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131165239));
        }
      }
    }
  }
  
  private List<MediaClipModel> b()
  {
    return bmkd.a(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  private void b(long paramLong)
  {
    this.jdField_a_of_type_Bmkf.a(CMTime.fromMs(paramLong));
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370195));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369426));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379920));
    this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(zau.a(getActivity(), "https://downv6.qq.com/video_story/qcircle/ttf/qircle_number_bold.ttf"));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new bmju(this));
    this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131366748));
    this.jdField_b_of_type_AndroidWidgetFrameLayout.setOnClickListener(new bmjv(this));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369139));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131366800));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369213));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new bmjw(this));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369385));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new bmje(this));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379873));
    this.jdField_a_of_type_DovComQqImAeeditorViewTimelineScaleScrollLayout = ((ScaleScrollLayout)paramView.findViewById(2131376785));
    this.jdField_a_of_type_DovComQqImAeeditorViewTimelineScaleScrollLayout.setOnClickListener(new bmjf(this));
    this.jdField_a_of_type_DovComQqImAeeditorViewReorderReorderContainerView = ((ReorderContainerView)paramView.findViewById(2131376334));
    this.jdField_a_of_type_DovComQqImAeeditorViewReorderReorderContainerView.a();
    this.jdField_a_of_type_DovComQqImAeeditorViewReorderReorderContainerView.setReorderListener(this.jdField_a_of_type_Bmom);
    this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleTimeBar = ((ScaleTimeBar)paramView.findViewById(2131377758));
    this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleTimeBar.setOnBarMoveListener(new bmjg(this));
    this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleTimeBar.setMaxDurationLimit(60000L);
    this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleTimeBar.setMaxDurationLimitTip(getString(2131689697));
    this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView = ((VideoTrackContainerView)paramView.findViewById(2131380975));
    this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView.setScaleAdapter(this.jdField_a_of_type_Bmoz);
    this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView.setMaxDurationLimit(60000L);
    this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView.setTimeBar(this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleTimeBar);
    this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView.setVideoModel(this.jdField_a_of_type_Bmkf);
    this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView.setScrollListener(new bmjh(this));
    this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView.setOnStartTimeChangedListener(new bmji(this));
    this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView.setSelectedStateListener(new bmjj(this));
    this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView.setOnTransitionListener(new bmjk(this));
    this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView.setVideoTrackStoreListener(new bmjl(this));
    this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView.setItemOnLongClickListener(new bmjm(this));
    paramView.setOnClickListener(new bmjn(this));
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
  
  private boolean b()
  {
    return (this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals("AEEditorMultiVideoEdit"));
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer != null) && (!this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.isPlaying())) {
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.play();
    }
  }
  
  private void c(long paramLong)
  {
    if ((this.jdField_a_of_type_Bmkf == null) || (!this.jdField_a_of_type_Bmkf.a())) {}
    do
    {
      return;
      if (this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleTimeBar != null) {
        this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleTimeBar.a(paramLong / 1000L);
      }
    } while (this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView == null);
    this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView.c();
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer != null) && (this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.isPlaying())) {
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.pause();
    }
  }
  
  @RequiresApi(api=16)
  private void e()
  {
    try
    {
      MediaResourceModel localMediaResourceModel = ((MediaResourceModel)getArguments().getSerializable("resource_model")).clone();
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
  
  private void f()
  {
    this.jdField_a_of_type_Bmoz = new bmoz();
    this.jdField_a_of_type_Bmoz.a(ViewUtils.dip2px(30.0F));
    this.jdField_a_of_type_Bmoz.b(ViewUtils.dip2px(20.0F));
  }
  
  private void g()
  {
    this.jdField_a_of_type_Bmkf = ((bmkf)blks.a(a()).get(bmkf.class));
  }
  
  @RequiresApi(api=16)
  private void h()
  {
    Object localObject = getArguments();
    if ((localObject != null) && (((Bundle)localObject).containsKey("ae_album_selected_media_models"))) {
      this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)((Bundle)localObject).getSerializable("ae_album_selected_media_models"));
    }
    localObject = new StringBuilder().append("passed in media models, size=");
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {}
    for (int i = 0;; i = this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      bmbx.a("AEEditorMultiCutEditFragment", i);
      this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleTimeBar.setScaleAdapter(this.jdField_a_of_type_Bmoz);
      this.jdField_a_of_type_Bmkf.a.observe(a(), new bmjr(this));
      a(b(), false);
      return;
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer != null)
    {
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.release();
      this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer = null;
    }
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer = new MoviePlayer();
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.setLoopPlay(true);
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.setBackColor(getResources().getColor(2131165216));
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.addPlayerListener(new bmjs(this));
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null)
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.release();
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession = null;
    }
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession = new TAVCutVideoSession();
    SessionConfig localSessionConfig = new SessionConfig();
    localSessionConfig.setContentMode(TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
    localSessionConfig.setRenderLayoutMode(VideoComposition.RenderLayoutMode.aspectFit);
    localSessionConfig.setMaxIntermediateRenderSize(this.jdField_a_of_type_Bmmg.a());
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setSessionConfig(localSessionConfig);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.addPlayer(this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setTAVCutVideoView(this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.initMultiCutSession(getActivity(), a());
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setTemplate(2, "assets://camera/template", true, new String[] { "template.json" });
    if (this.jdField_a_of_type_Bmkf != null) {
      this.jdField_a_of_type_Bmkf.a(this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer);
    }
    this.jdField_b_of_type_JavaLangString = Util.md5(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().toString());
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_Bmhk == null)
    {
      this.jdField_a_of_type_Bmhk = new bmhk(getActivity(), 2131755189);
      this.jdField_a_of_type_Bmhk.c(85);
      this.jdField_a_of_type_Bmhk.b((UIUtils.getScreenWidth(getActivity()) - bnnl.b(getActivity(), 65.0F)) / 2);
      this.jdField_a_of_type_Bmhk.a(bnnl.b(getActivity(), 212.0F));
      this.jdField_a_of_type_Bmhk.a(new bmjp(this));
    }
    this.jdField_a_of_type_Bmhk.show();
    if (this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView != null)
    {
      CutModelKt localCutModelKt = this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView.a();
      if ((localCutModelKt != null) && (localCutModelKt.getResource() != null)) {
        this.jdField_a_of_type_Bmhk.a(localCutModelKt.getResource().getScaleSpeed());
      }
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_AndroidTextSpannableStringBuilder == null)
    {
      String str1 = getResources().getString(2131689691);
      String str2 = "  " + getResources().getString(2131689698);
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      localSpannableStringBuilder.append(str1);
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(2131165240)), 0, str1.length(), 17);
      localSpannableStringBuilder.append(str2);
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(2131165239)), str1.length(), localSpannableStringBuilder.length(), 17);
      this.jdField_a_of_type_AndroidTextSpannableStringBuilder = localSpannableStringBuilder;
    }
  }
  
  public String a()
  {
    return "AEEditorMultiCutFragment";
  }
  
  @RequiresApi(api=16)
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    bmbx.b("AEEditorMultiCutEditFragment", "doOnActivityResult---requestCode=" + paramInt1 + ", resultCode=" + paramInt2);
    if ((paramInt1 == 1024) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getSerializableExtra("ae_album_selected_media_models");
      if (paramIntent == null) {
        bmbx.a("AEEditorMultiCutEditFragment", "serializableExtra == null");
      }
    }
    else
    {
      return;
    }
    Object localObject = (ArrayList)paramIntent;
    bmbx.a("AEEditorMultiCutEditFragment", "ADDITIONAL passed in media models, size=" + ((ArrayList)localObject).size());
    if (((ArrayList)localObject).size() == 0)
    {
      bmbx.a("AEEditorMultiCutEditFragment", "addMediaModels.size() == 0");
      return;
    }
    if (this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView == null)
    {
      bmbx.a("AEEditorMultiCutEditFragment", "mVideoTrackContainer == null");
      return;
    }
    paramInt2 = this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView.b();
    paramIntent = bmkd.a((List)localObject);
    localObject = bmkd.b((List)localObject);
    paramIntent = StoreModelConvert.INSTANCE.convert(paramIntent);
    paramIntent = bmkc.a(paramInt2, this.jdField_a_of_type_JavaUtilList, paramIntent, (List)localObject, this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel());
    if (MediaModelUtils.getTotalSelectDuration(paramIntent.getMediaClipModel()) >= 60000L)
    {
      localObject = StoreModelConvert.INSTANCE.restoreClipTimeRange(paramIntent.getData());
      paramIntent = new ResourceModel(paramIntent.getSelectUuid(), paramIntent.getFlashing(), (List)localObject, paramIntent.getBackupData(), paramIntent.getTransitionData(), paramIntent.getTransitionPosition(), paramIntent.getSmartCutType());
    }
    for (;;)
    {
      if (paramIntent.getMediaClipModel().size() >= 2) {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130837903);
      }
      long l = 0L;
      paramInt1 = 0;
      while (paramInt1 <= paramInt2)
      {
        l += ((MediaClipModel)paramIntent.getMediaClipModel().get(paramInt1)).getResource().getScaleDuration();
        paramInt1 += 1;
      }
      a(l);
      this.jdField_a_of_type_Bmkf.a.postValue(paramIntent);
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
        localObject = bfur.a((Context)localObject, 230).setTitle(amtj.a(2131689718)).setMessage(((Context)localObject).getString(2131689719)).setPositiveButton(((Context)localObject).getString(2131689718), new bmjq(this)).setNegativeButton(((Context)localObject).getString(2131689690), new bmjo(this));
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
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_c_of_type_Boolean = true;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    f();
    g();
    paramLayoutInflater = paramLayoutInflater.inflate(2131558559, paramViewGroup, false);
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
    super.onHiddenChanged(paramBoolean);
    this.jdField_d_of_type_Boolean = paramBoolean;
    if (!paramBoolean)
    {
      if (b())
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.setStyleAsCancelAndFinish();
        if ((this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null) && (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel() != null)) {
          e();
        }
      }
      for (;;)
      {
        if (this.jdField_c_of_type_Boolean) {
          c();
        }
        bmbc.a().A();
        return;
        this.jdField_a_of_type_Boolean = false;
        if ((getArguments() != null) && ((getArguments().getSerializable("resource_model") instanceof MediaResourceModel))) {
          e();
        }
        this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.setLeftButtonAsBackArray();
      }
    }
    d();
  }
  
  public void onPause()
  {
    super.onPause();
    if (!this.jdField_d_of_type_Boolean) {
      d();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (!this.jdField_d_of_type_Boolean)
    {
      if (this.jdField_b_of_type_Boolean) {
        c();
      }
      bmbc.a().A();
    }
  }
  
  @RequiresApi(api=16)
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a(paramView);
    b(paramView);
    h();
    i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment
 * JD-Core Version:    0.7.0.1
 */