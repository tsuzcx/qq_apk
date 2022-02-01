package dov.com.qq.im.aeeditor.module.edit.multi;

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
import anvx;
import bhdj;
import bmxz;
import bnqm;
import bnrh;
import bnxc;
import bnyu;
import bnyw;
import bnyx;
import bnyy;
import bnyz;
import bnza;
import bnzb;
import bnzc;
import bnzd;
import bnze;
import bnzf;
import bnzg;
import bnzh;
import bnzi;
import bnzj;
import bnzk;
import bnzl;
import bnzm;
import bnzn;
import bnzo;
import bnzu;
import bnzv;
import bnzw;
import bnzx;
import bobw;
import boby;
import bodv;
import boee;
import boer;
import bpdd;
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
import zpz;

public class AEEditorMultiCutEditFragment
  extends AEEditorBaseFragment
{
  private int jdField_a_of_type_Int = ScreenUtil.dip2px(73.0F);
  private SpannableStringBuilder jdField_a_of_type_AndroidTextSpannableStringBuilder;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bnxc jdField_a_of_type_Bnxc;
  private bnzx jdField_a_of_type_Bnzx;
  private boby jdField_a_of_type_Boby = bobw.a();
  private boee jdField_a_of_type_Boee = new bnyu(this);
  private boer jdField_a_of_type_Boer;
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
    return this.jdField_a_of_type_Boer.a(getResources().getDimension(2131296284));
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
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar = ((AEEditorTopBar)paramView.findViewById(2131379218));
    this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView = ((TAVCutVideoView)paramView.findViewById(2131378517));
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.setTopBarClickListener(new bnzl(this));
  }
  
  @RequiresApi(api=16)
  private void a(bodv parambodv)
  {
    if ((parambodv == null) || (((View)parambodv).getParent() == null)) {}
    for (;;)
    {
      return;
      long l1 = this.jdField_a_of_type_Boer.c();
      long l2 = this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView.a(parambodv);
      long l3 = this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView.b(parambodv);
      if ((this.f) || (this.g) || (l2 >= l1) || (l3 <= l1))
      {
        if (this.f)
        {
          l1 = a() + l2;
          this.f = false;
          bnrh.a("AEEditorMultiCutEditFragment", "起始点变化，滚到view的起始位置. 旧方法计算的时间：" + l2 + ". 新方法：" + l1);
        }
        while (l1 != 9223372036854775807L)
        {
          if (l1 < 0L)
          {
            bnrh.a("AEEditorMultiCutEditFragment", "targetTime小于0，设置为0");
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
              bnrh.a("AEEditorMultiCutEditFragment", "结束点变化，滚到view的结束位置. 旧方法计算的时间：" + l3 + ". 新方法:" + l1);
              break;
            }
            if ((l3 >= 0L) && (l3 <= l1))
            {
              l1 = l3 - a();
              bnrh.a("AEEditorMultiCutEditFragment", "滑块在屏幕左边，滚到view的结束位置. 旧方法：" + l3 + ". 新方法：" + l1);
              break;
            }
            if ((l2 < 0L) || (l2 < l1)) {
              break label411;
            }
            l1 = a() + l2;
            bnrh.a("AEEditorMultiCutEditFragment", "滑块在屏幕右边，滚到view的开始位置. 旧方法：" + l2 + ". 新方法：" + l1);
            break;
            l2 = l1;
            if (l1 > this.jdField_a_of_type_Boer.b())
            {
              l2 = this.jdField_a_of_type_Boer.b();
              bnrh.a("AEEditorMultiCutEditFragment", "targetTime大于endValue，设置为endValue：" + l2);
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
    this.jdField_a_of_type_Boer.a(paramResourceModel.getAllVideoDuration() - i);
    this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleTimeBar.a(this.jdField_a_of_type_Boer);
  }
  
  @RequiresApi(api=16)
  private void a(String paramString, long paramLong1, long paramLong2)
  {
    long l = CutExtKt.calculateClipSeek(this.jdField_a_of_type_JavaUtilList, new LinkedList(), paramString);
    if (l >= 0L) {
      a(l);
    }
    this.jdField_a_of_type_Bnzx.a.postValue(bnzu.a(paramString, paramLong1, paramLong2, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel()));
    bnqm.a().D();
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
    this.jdField_a_of_type_Bnzx.a.postValue(bnzu.a(localList1, null));
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
          if ((this.jdField_a_of_type_Bnxc != null) && (this.jdField_a_of_type_Bnxc.isShowing())) {
            this.jdField_a_of_type_Bnxc.dismiss();
          }
        }
        else
        {
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          if (bnzw.a(localCutModelKt.getResource().getScaleSpeed(), 1.0F))
          {
            this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130837906);
            return;
          }
          this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130837907);
        }
      }
      else
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        if (this.jdField_a_of_type_Boer.b() > 60000L)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          k();
          this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidTextSpannableStringBuilder);
        }
        while ((this.jdField_a_of_type_Bnxc != null) && (this.jdField_a_of_type_Bnxc.isShowing()))
        {
          this.jdField_a_of_type_Bnxc.dismiss();
          return;
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetTextView.setText(2131689706);
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131165240));
        }
      }
    }
  }
  
  private List<MediaClipModel> b()
  {
    return bnzv.a(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  private void b(long paramLong)
  {
    this.jdField_a_of_type_Bnzx.a(CMTime.fromMs(paramLong));
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370369));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369595));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380258));
    this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(zpz.a(getActivity(), "https://downv6.qq.com/video_story/qcircle/ttf/qircle_number_bold.ttf"));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new bnzm(this));
    this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131366864));
    this.jdField_b_of_type_AndroidWidgetFrameLayout.setOnClickListener(new bnzn(this));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369302));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131366918));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369376));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new bnzo(this));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369551));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new bnyw(this));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380206));
    this.jdField_a_of_type_DovComQqImAeeditorViewTimelineScaleScrollLayout = ((ScaleScrollLayout)paramView.findViewById(2131377054));
    this.jdField_a_of_type_DovComQqImAeeditorViewTimelineScaleScrollLayout.setOnClickListener(new bnyx(this));
    this.jdField_a_of_type_DovComQqImAeeditorViewReorderReorderContainerView = ((ReorderContainerView)paramView.findViewById(2131376589));
    this.jdField_a_of_type_DovComQqImAeeditorViewReorderReorderContainerView.a();
    this.jdField_a_of_type_DovComQqImAeeditorViewReorderReorderContainerView.setReorderListener(this.jdField_a_of_type_Boee);
    this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleTimeBar = ((ScaleTimeBar)paramView.findViewById(2131378039));
    this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleTimeBar.setOnBarMoveListener(new bnyy(this));
    this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleTimeBar.setMaxDurationLimit(60000L);
    this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleTimeBar.setMaxDurationLimitTip(getString(2131689705));
    this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView = ((VideoTrackContainerView)paramView.findViewById(2131381327));
    this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView.setScaleAdapter(this.jdField_a_of_type_Boer);
    this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView.setMaxDurationLimit(60000L);
    this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView.setTimeBar(this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleTimeBar);
    this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView.setVideoModel(this.jdField_a_of_type_Bnzx);
    this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView.setScrollListener(new bnyz(this));
    this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView.setOnStartTimeChangedListener(new bnza(this));
    this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView.setSelectedStateListener(new bnzb(this));
    this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView.setOnTransitionListener(new bnzc(this));
    this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView.setVideoTrackStoreListener(new bnzd(this));
    this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView.setItemOnLongClickListener(new bnze(this));
    paramView.setOnClickListener(new bnzf(this));
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
    if ((this.jdField_a_of_type_Bnzx == null) || (!this.jdField_a_of_type_Bnzx.a())) {}
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
    this.jdField_a_of_type_Boer = new boer();
    this.jdField_a_of_type_Boer.a(ViewUtils.dip2px(30.0F));
    this.jdField_a_of_type_Boer.b(ViewUtils.dip2px(20.0F));
  }
  
  private void g()
  {
    this.jdField_a_of_type_Bnzx = ((bnzx)bmxz.a(a()).get(bnzx.class));
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
      bnrh.a("AEEditorMultiCutEditFragment", i);
      this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleTimeBar.setScaleAdapter(this.jdField_a_of_type_Boer);
      this.jdField_a_of_type_Bnzx.a.observe(a(), new bnzj(this));
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
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.addPlayerListener(new bnzk(this));
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null)
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.release();
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession = null;
    }
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession = new TAVCutVideoSession();
    SessionConfig localSessionConfig = new SessionConfig();
    localSessionConfig.setContentMode(TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
    localSessionConfig.setRenderLayoutMode(VideoComposition.RenderLayoutMode.aspectFit);
    localSessionConfig.setMaxIntermediateRenderSize(this.jdField_a_of_type_Boby.a());
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setSessionConfig(localSessionConfig);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.addPlayer(this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setTAVCutVideoView(this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.initMultiCutSession(getActivity(), a());
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.setTemplate(2, "assets://camera/template", true, new String[] { "template.json" });
    if (this.jdField_a_of_type_Bnzx != null) {
      this.jdField_a_of_type_Bnzx.a(this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer);
    }
    this.jdField_b_of_type_JavaLangString = Util.md5(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().toString());
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_Bnxc == null)
    {
      this.jdField_a_of_type_Bnxc = new bnxc(getActivity(), 2131755189);
      this.jdField_a_of_type_Bnxc.c(85);
      this.jdField_a_of_type_Bnxc.b((UIUtils.getScreenWidth(getActivity()) - bpdd.b(getActivity(), 65.0F)) / 2);
      this.jdField_a_of_type_Bnxc.a(bpdd.b(getActivity(), 212.0F));
      this.jdField_a_of_type_Bnxc.a(new bnzh(this));
    }
    this.jdField_a_of_type_Bnxc.show();
    if (this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView != null)
    {
      CutModelKt localCutModelKt = this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView.a();
      if ((localCutModelKt != null) && (localCutModelKt.getResource() != null)) {
        this.jdField_a_of_type_Bnxc.a(localCutModelKt.getResource().getScaleSpeed());
      }
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_AndroidTextSpannableStringBuilder == null)
    {
      String str1 = getResources().getString(2131689699);
      String str2 = "  " + getResources().getString(2131689706);
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      localSpannableStringBuilder.append(str1);
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(2131165241)), 0, str1.length(), 17);
      localSpannableStringBuilder.append(str2);
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(2131165240)), str1.length(), localSpannableStringBuilder.length(), 17);
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
    bnrh.b("AEEditorMultiCutEditFragment", "doOnActivityResult---requestCode=" + paramInt1 + ", resultCode=" + paramInt2);
    if ((paramInt1 == 1024) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getSerializableExtra("ae_album_selected_media_models");
      if (paramIntent == null) {
        bnrh.a("AEEditorMultiCutEditFragment", "serializableExtra == null");
      }
    }
    else
    {
      return;
    }
    Object localObject = (ArrayList)paramIntent;
    bnrh.a("AEEditorMultiCutEditFragment", "ADDITIONAL passed in media models, size=" + ((ArrayList)localObject).size());
    if (((ArrayList)localObject).size() == 0)
    {
      bnrh.a("AEEditorMultiCutEditFragment", "addMediaModels.size() == 0");
      return;
    }
    if (this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView == null)
    {
      bnrh.a("AEEditorMultiCutEditFragment", "mVideoTrackContainer == null");
      return;
    }
    paramInt2 = this.jdField_a_of_type_DovComQqImAeeditorViewVideotrackVideoTrackContainerView.b();
    paramIntent = bnzv.a((List)localObject);
    localObject = bnzv.b((List)localObject);
    paramIntent = StoreModelConvert.INSTANCE.convert(paramIntent);
    paramIntent = bnzu.a(paramInt2, this.jdField_a_of_type_JavaUtilList, paramIntent, (List)localObject, this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel());
    if (MediaModelUtils.getTotalSelectDuration(paramIntent.getMediaClipModel()) >= 60000L)
    {
      localObject = StoreModelConvert.INSTANCE.restoreClipTimeRange(paramIntent.getData());
      paramIntent = new ResourceModel(paramIntent.getSelectUuid(), paramIntent.getFlashing(), (List)localObject, paramIntent.getBackupData(), paramIntent.getTransitionData(), paramIntent.getTransitionPosition(), paramIntent.getSmartCutType());
    }
    for (;;)
    {
      if (paramIntent.getMediaClipModel().size() >= 2) {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130837917);
      }
      long l = 0L;
      paramInt1 = 0;
      while (paramInt1 <= paramInt2)
      {
        l += ((MediaClipModel)paramIntent.getMediaClipModel().get(paramInt1)).getResource().getScaleDuration();
        paramInt1 += 1;
      }
      a(l);
      this.jdField_a_of_type_Bnzx.a.postValue(paramIntent);
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
        localObject = bhdj.a((Context)localObject, 230).setTitle(anvx.a(2131689726)).setMessage(((Context)localObject).getString(2131689727)).setPositiveButton(((Context)localObject).getString(2131689726), new bnzi(this)).setNegativeButton(((Context)localObject).getString(2131689698), new bnzg(this));
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
    paramLayoutInflater = paramLayoutInflater.inflate(2131558570, paramViewGroup, false);
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
        bnqm.a().A();
        return;
        this.jdField_a_of_type_Boolean = false;
        if ((getArguments() != null) && ((getArguments().getSerializable("resource_model") instanceof MediaResourceModel))) {
          e();
        }
        this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.setLeftButtonAsBackArray();
      }
    }
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.onPause();
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
      bnqm.a().A();
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