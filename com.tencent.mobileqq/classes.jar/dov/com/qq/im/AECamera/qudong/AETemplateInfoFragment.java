package dov.com.qq.im.AECamera.qudong;

import abju;
import abjv;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bbmy;
import bgww;
import bgxa;
import bgxb;
import bgyg;
import bhaq;
import bhar;
import bhas;
import bhat;
import bhau;
import bhbv;
import bhcc;
import bhci;
import bhcp;
import bhcs;
import biqy;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.openapi.initializer.MediaInitializer;
import com.tencent.ttpic.openapi.initializer.PagInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.openapi.offlineset.OfflineConfig;
import com.tencent.ttpic.openapi.offlineset.OfflineFileUpdater;
import com.tencent.ttpic.videoshelf.libpag.PagNotSupportSystemException;
import com.tencent.ttpic.videoshelf.model.edit.NodeGroup;
import com.tencent.ttpic.videoshelf.model.edit.NodeItem;
import com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer;
import com.tencent.ttpic.videoshelf.model.player.PagShelfPlayer;
import com.tencent.ttpic.videoshelf.model.player.VideoShelfPlayer;
import com.tencent.ttpic.videoshelf.model.template.MaskNodeGroup;
import com.tencent.ttpic.videoshelf.model.template.MaskNodeItem;
import com.tencent.ttpic.videoshelf.model.template.VideoShelfTemplate;
import com.tencent.ttpic.videoshelf.parser.TemplateParser;
import com.tencent.ttpic.videoshelf.utils.TTPTLogger;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class AETemplateInfoFragment
  extends IphoneTitleBarFragment
  implements abjv, View.OnClickListener
{
  public static final String a;
  private int jdField_a_of_type_Int;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private TextureView jdField_a_of_type_AndroidViewTextureView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bhat jdField_a_of_type_Bhat;
  private IVideoShelfPlayer jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer;
  private VideoShelfTemplate jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  private List<NodeGroup> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private Dialog jdField_b_of_type_AndroidAppDialog;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private List<String> jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = true;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private String jdField_e_of_type_JavaLangString = "";
  private boolean jdField_e_of_type_Boolean;
  private String jdField_f_of_type_JavaLangString;
  private boolean jdField_f_of_type_Boolean;
  private String g;
  
  static
  {
    jdField_a_of_type_JavaLangString = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "tencent" + File.separator + "MobileQQ" + File.separator + "qudong_crazyface_tmp" + File.separator;
  }
  
  public static int a(Context paramContext)
  {
    if ((paramContext instanceof Activity)) {
      return ((Activity)paramContext).getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", bgww.a.a());
    }
    return bgww.a.a();
  }
  
  private String a(VideoShelfTemplate paramVideoShelfTemplate)
  {
    int i = 0;
    if (paramVideoShelfTemplate == null) {}
    Object localObject1;
    do
    {
      return "";
      localObject1 = paramVideoShelfTemplate.getTipTemplate();
    } while ((localObject1 == null) || (localObject1.length == 0));
    int j = localObject1[0];
    Object localObject2 = getResources();
    paramVideoShelfTemplate = "";
    if (localObject2 != null) {
      paramVideoShelfTemplate = String.format("需选择%d张图片", new Object[] { Integer.valueOf(j) });
    }
    if (j == 0) {
      paramVideoShelfTemplate = "";
    }
    if (localObject1.length > 1) {
      i = localObject1[1];
    }
    if (i > 0)
    {
      localObject1 = "可修改文字";
      if ((TextUtils.isEmpty(paramVideoShelfTemplate)) || (TextUtils.isEmpty((CharSequence)localObject1)) || (!this.jdField_d_of_type_Boolean)) {
        break label147;
      }
    }
    label147:
    for (localObject2 = " ";; localObject2 = "")
    {
      return paramVideoShelfTemplate + (String)localObject2 + (String)localObject1;
      localObject1 = "";
      break;
    }
  }
  
  private void a(int paramInt)
  {
    bgyg.a(getActivity(), paramInt);
  }
  
  public static void a(Context paramContext, Intent paramIntent)
  {
    paramIntent.addFlags(67108864);
    paramIntent.addFlags(536870912);
    paramIntent.putExtra("VIDEO_STORY_FROM_TYPE", a(paramContext));
    abju.a(paramContext, paramIntent, PublicFragmentActivityForPeak.class, AETemplateInfoFragment.class);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("MaterialPath", paramString2);
    localIntent.putExtra("MaterialId", paramString3);
    localIntent.putExtra("MaterialName", paramString4);
    localIntent.putExtra("loc_play_show_tab_name", paramString1);
    localIntent.putExtra("VIDEO_STORY_FROM_TYPE", a(paramContext));
    abju.a(paramContext, localIntent, PublicFragmentActivityForPeak.class, AETemplateInfoFragment.class);
  }
  
  private void a(SurfaceTexture paramSurfaceTexture)
  {
    int j = 1;
    QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---surfaceTextureAvailable");
    this.jdField_b_of_type_Boolean = true;
    if ((this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate == null) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {
      b(this.jdField_b_of_type_JavaLangString);
    }
    label163:
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer == null)
        {
          if ((this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate == null) || (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVersion() != 1)) {
            break label163;
          }
          i = j;
          if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getPreviewVideoPath() != null)
          {
            if (FileUtils.exists(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getPreviewVideoPath())) {
              break label163;
            }
            i = j;
          }
          if (i != 0)
          {
            localObject = new PagShelfPlayer();
            this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer = ((IVideoShelfPlayer)localObject);
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer.setSurface(new Surface(paramSurfaceTexture));
          n();
          return;
        }
        Object localObject = new VideoShelfPlayer();
        continue;
        int i = 0;
      }
      catch (PagNotSupportSystemException paramSurfaceTexture)
      {
        TTPTLogger.e("AETemplateInfoFragment", paramSurfaceTexture.getMessage());
        c("pag版本过低");
        return;
      }
    }
  }
  
  private void a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.isEmpty())) {}
    Bitmap localBitmap;
    do
    {
      return;
      localBitmap = BitmapUtils.decodeSampleBitmap(getActivity(), paramString, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    } while (localBitmap == null);
    bgxb.a().a("ae_preference_k_qudong_last_crazy_face_photo", paramString, 0);
    b(true);
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_Boolean = false;
    s();
    bhbv.a(localBitmap, this.jdField_b_of_type_JavaUtilList, new bhas(this, paramString, localBitmap, l));
  }
  
  private void a(boolean paramBoolean)
  {
    int i = 0;
    Log.i("AETemplateInfoFragment", "未合成视频，将直接实时预览。");
    TTPTLogger.i("AETemplateInfoFragment", "未合成视频，将直接实时预览。");
    this.jdField_f_of_type_JavaLangString = AEVideoShelfEditFragment.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("from", true);
    if (!paramBoolean) {}
    HashMap localHashMap;
    for (paramBoolean = true;; paramBoolean = false)
    {
      localIntent.putExtra("isNeedEditButton", paramBoolean);
      localIntent.putExtra("usePagPreview", true);
      localIntent.putExtra("videoOutWidth", this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoWidth());
      localIntent.putExtra("videoOutHeight", this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoHeight());
      localIntent.putExtra("pagFilePath", this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getPagFilePath());
      localIntent.putExtra("audioFilePath", this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getAudioPath());
      localIntent.putExtra("MaterialPath", this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getMaterialPath());
      localIntent.putExtra("MaterialName", this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoName());
      localIntent.putExtra("loc_play_show_tab_name", this.jdField_e_of_type_JavaLangString);
      localIntent.putExtra("loc_play_show_material_id", this.jdField_c_of_type_JavaLangString);
      localIntent.putExtra("VIDEO_STORY_FROM_TYPE", a(getActivity()));
      localIntent.putStringArrayListExtra("PhotoList", this.jdField_a_of_type_JavaUtilArrayList);
      localIntent.putExtra("MaterialId", this.jdField_c_of_type_JavaLangString);
      l();
      localHashMap = new HashMap();
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      Iterator localIterator = ((NodeGroup)((Iterator)localObject).next()).nodeItemList.iterator();
      int j = i;
      for (;;)
      {
        i = j;
        if (!localIterator.hasNext()) {
          break;
        }
        NodeItem localNodeItem = (NodeItem)localIterator.next();
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (j < this.jdField_a_of_type_JavaUtilArrayList.size()))
        {
          localHashMap.put(this.jdField_a_of_type_JavaUtilArrayList.get(j), localNodeItem.indexLayerForPag);
          j += 1;
        }
      }
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putSerializable("nodeImgList", localHashMap);
    localIntent.putExtras((Bundle)localObject);
    AEVideoShelfPreviewFragment.a(getActivity(), localIntent, 1);
  }
  
  private boolean a()
  {
    return false;
  }
  
  private void b()
  {
    View localView = getView();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131305123));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131302362));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localView.findViewById(2131303311));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131311534));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131311502));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131306069));
    if (a())
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setText("0(fps)");
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-65536);
    }
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131306070));
    this.jdField_a_of_type_AndroidViewTextureView = ((TextureView)localView.findViewById(2131306218));
    this.jdField_a_of_type_AndroidViewTextureView.setKeepScreenOn(true);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localView.findViewById(2131306064));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.getViewTreeObserver().addOnGlobalLayoutListener(new bhaq(this));
    this.jdField_a_of_type_AndroidViewTextureView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewTextureView.setSurfaceTextureListener(new bhau(this));
    this.jdField_a_of_type_Bhat = new bhat(this);
    if (this.jdField_f_of_type_Boolean)
    {
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130837608);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131624261);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
    else {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText(2131624259);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  private void b(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate == null) {
        this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate = TemplateParser.parse(getActivity(), paramString);
      }
      return;
    }
    catch (IllegalArgumentException paramString)
    {
      TTPTLogger.w("AETemplateInfoFragment", "loadTemplate Error!");
    }
  }
  
  private void b(boolean paramBoolean)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && (!localFragmentActivity.isFinishing()))
    {
      if (!paramBoolean) {
        break label76;
      }
      if (this.jdField_a_of_type_AndroidAppDialog == null)
      {
        this.jdField_a_of_type_AndroidAppDialog = new Dialog(localFragmentActivity, 2131690181);
        this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
        this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
        this.jdField_a_of_type_AndroidAppDialog.setContentView(2131493818);
      }
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
    label76:
    while ((this.jdField_a_of_type_AndroidAppDialog == null) || (!this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      return;
    }
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
  }
  
  private boolean b()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate == null) {
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getPagFileName() != null) && (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getPagFilePath() != null) && (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getPreviewVideoType() == 1) && (!OfflineConfig.isNotSuptPagRealTime())) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private void c()
  {
    this.jdField_b_of_type_Int = biqy.a(getActivity());
    this.jdField_c_of_type_Int = biqy.b(getActivity());
    Intent localIntent = getActivity().getIntent();
    if (localIntent != null)
    {
      this.jdField_b_of_type_JavaLangString = localIntent.getStringExtra("MaterialPath");
      this.jdField_c_of_type_JavaLangString = localIntent.getStringExtra("MaterialId");
      this.jdField_d_of_type_JavaLangString = localIntent.getStringExtra("MaterialName");
      this.jdField_e_of_type_JavaLangString = localIntent.getStringExtra("loc_play_show_tab_name");
    }
    if ((this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate == null) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {
      b(this.jdField_b_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate != null)
    {
      this.jdField_b_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getCrazyFaceList();
      if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.isEmpty())) {
        break label240;
      }
    }
    label240:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_f_of_type_Boolean = bool;
      if (this.jdField_f_of_type_Boolean)
      {
        this.g = bgxb.a().a("ae_preference_k_qudong_last_crazy_face_photo", null, 0);
        if (!TextUtils.isEmpty(this.g))
        {
          int i = getActivity().getResources().getDimensionPixelSize(2131165196);
          int j = getActivity().getResources().getDimensionPixelSize(2131165197);
          this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapUtils.decodeSampleBitmap(getActivity(), this.g, j, i);
        }
      }
      OfflineFileUpdater.setHttpClient(new bhcc());
      OfflineFileUpdater.checkOfflineFile();
      return;
    }
  }
  
  private void c(String paramString) {}
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer != null)
    {
      if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer.isPlaying())
      {
        this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer.pause();
        f();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer.start();
    e();
  }
  
  private void e()
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void f()
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  private void g()
  {
    int i1 = 1;
    if ((this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getMaterialPath())))
    {
      TTPTLogger.w("AETemplateInfoFragment", "onNext template Error!");
      return;
    }
    if (this.jdField_f_of_type_Boolean)
    {
      h();
      return;
    }
    int k = 0;
    int j = 0;
    int m;
    for (int i = 0; k < this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getNodeGroupList().size(); i = m)
    {
      int n = j;
      m = i;
      if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getNodeGroupList().get(k) != null)
      {
        n = j;
        m = i;
        if (((MaskNodeGroup)this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getNodeGroupList().get(k)).getNodeList() != null)
        {
          m = 0;
          if (m < ((MaskNodeGroup)this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getNodeGroupList().get(k)).getNodeList().size())
          {
            if (((MaskNodeItem)((MaskNodeGroup)this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getNodeGroupList().get(k)).getNodeList().get(m)).getType() != 1) {
              i += 1;
            }
            for (;;)
            {
              m += 1;
              break;
              j += 1;
            }
          }
          m = i;
          n = j;
        }
      }
      k += 1;
      j = n;
    }
    boolean bool;
    if (j > 0)
    {
      bool = true;
      this.jdField_e_of_type_Boolean = bool;
      if ((j <= 0) || (i != 0)) {
        break label262;
      }
    }
    label262:
    for (j = i1;; j = 0)
    {
      if (j == 0) {
        break label267;
      }
      m();
      return;
      bool = false;
      break;
    }
    label267:
    a(i);
  }
  
  private void h()
  {
    if (!b())
    {
      bbmy.a(getActivity(), getActivity().getString(2131624252), 0).a();
      return;
    }
    if (bgxb.a().a("key_first_change_face_click_flag", true, 0))
    {
      bgxb.a().a("key_first_change_face_click_flag", false, 0);
      i();
      return;
    }
    bgxa.a(getActivity(), 1024, bgww.v.a());
  }
  
  private void i()
  {
    if (this.jdField_b_of_type_AndroidAppDialog != null) {
      if (this.jdField_b_of_type_AndroidAppDialog.isShowing()) {
        this.jdField_b_of_type_AndroidAppDialog.dismiss();
      }
    }
    for (;;)
    {
      if (!this.jdField_b_of_type_AndroidAppDialog.isShowing()) {
        this.jdField_b_of_type_AndroidAppDialog.show();
      }
      return;
      this.jdField_b_of_type_AndroidAppDialog = new Dialog(getActivity(), 2131690181);
      this.jdField_b_of_type_AndroidAppDialog.setCancelable(true);
      this.jdField_b_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
      this.jdField_b_of_type_AndroidAppDialog.setContentView(2131492951);
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = getActivity().getResources().getDrawable(2131101537);
      localObject = URLDrawable.getDrawable("http://dl.url.cn/myapp/qq_desk/qqrm/videofilter/Pturenwu/tipss.png", (URLDrawable.URLDrawableOptions)localObject);
      URLImageView localURLImageView = (URLImageView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131302791);
      TextView localTextView = (TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131312195);
      localURLImageView.setImageDrawable((Drawable)localObject);
      this.jdField_b_of_type_AndroidAppDialog.show();
      localTextView.setOnClickListener(new bhar(this));
    }
  }
  
  private void j()
  {
    if ((this.jdField_b_of_type_AndroidAppDialog != null) && (this.jdField_b_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_b_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  private void k()
  {
    b(true);
    a(false);
    b(false);
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getNodeGroupList().size())
      {
        Object localObject = (MaskNodeGroup)this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getNodeGroupList().get(i);
        NodeGroup localNodeGroup = new NodeGroup();
        localNodeGroup.nodeGroupID = ((MaskNodeGroup)localObject).getNodeGroupID();
        localObject = ((MaskNodeGroup)localObject).getNodeList();
        localNodeGroup.nodeItemList = new ArrayList();
        int j = 0;
        while (j < ((List)localObject).size())
        {
          MaskNodeItem localMaskNodeItem = (MaskNodeItem)((List)localObject).get(j);
          NodeItem localNodeItem = new NodeItem();
          localNodeItem.nodeID = localMaskNodeItem.getNodeID();
          localNodeItem.nodeGroupID = localMaskNodeItem.getNodeGroupID();
          localNodeItem.zIndex = localMaskNodeItem.getZIndex();
          localNodeItem.indexLayerForPag = localMaskNodeItem.getIndexLayerForPag();
          localNodeGroup.nodeItemList.add(localNodeItem);
          j += 1;
        }
        this.jdField_a_of_type_JavaUtilList.add(localNodeGroup);
        i += 1;
      }
    }
  }
  
  private void m()
  {
    AEVideoShelfEditFragment.a(getActivity(), this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getMaterialPath(), this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getVideoName(), this.jdField_a_of_type_JavaUtilArrayList, 1);
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate != null)
    {
      o();
      q();
    }
  }
  
  private void o()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getName());
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getTip());
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_d_of_type_JavaLangString);
    getActivity().findViewById(2131299458).setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
    this.jdField_c_of_type_AndroidWidgetTextView.setLines(2);
    localLayoutParams.height = ((int)(32.0F * this.jdField_c_of_type_AndroidWidgetTextView.getContext().getResources().getDisplayMetrics().density));
    this.jdField_c_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(a(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate));
  }
  
  private void p()
  {
    TTPTLogger.w("AETemplateInfoFragment", "onPlayError!");
  }
  
  private void q()
  {
    if ((this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate == null) || (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer.reset();
    this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer.setVideoShelfPlayerListener(this.jdField_a_of_type_Bhat);
    String str2 = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getPreviewVideoPath();
    String str1 = null;
    if ((this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer instanceof PagShelfPlayer))
    {
      str2 = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getPagFilePath();
      str1 = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.getAudioPath();
    }
    if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelTemplateVideoShelfTemplate.isFromAssets())
    {
      this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer.setDataSource(getActivity().getAssets(), str2);
      if ((str1 != null) && (FileUtils.exists(str1))) {
        this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer.setParam("pagShelfPlayerAudioFilePath", new Object[] { Boolean.valueOf(true), getActivity().getAssets(), str1 });
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer.prepare();
      this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer.seekTo(this.jdField_a_of_type_Int);
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer.start();
      QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---mVideoPlayer.start() in playVideo");
      return;
      this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer.setDataSource(str2);
      if ((str1 != null) && (FileUtils.exists(str1))) {
        this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer.setParam("pagShelfPlayerAudioFilePath", new Object[] { Boolean.valueOf(false), str1 });
      }
    }
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer != null)
    {
      if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer.isPlaying())
      {
        this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer.stop();
        QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---stopVideo done");
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer.setSurface(null);
        this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer.getCurrentPosition();
        f();
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer = null;
        return;
        QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---stopVideo enter, mVideoPlayer is not playing");
      }
    }
    QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---stopVideo enter, mVideoPlayer is null");
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer != null)
    {
      if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer.isPlaying())
      {
        this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer.pause();
        QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---pauseVideo done");
        f();
        return;
      }
      QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---pauseVideo enter, mVideoPlayer is not playing");
      return;
    }
    QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---pauseVideo enter, mVideoPlayer is null");
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer != null) {
      a();
    }
  }
  
  private void u()
  {
    QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---surfaceTextureDestroyed");
    this.jdField_b_of_type_Boolean = false;
    r();
  }
  
  public void a()
  {
    QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---onPlayComplete");
    if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer != null) {
      this.jdField_a_of_type_ComTencentTtpicVideoshelfModelPlayerIVideoShelfPlayer.seekTo(0);
    }
    f();
    this.jdField_a_of_type_Boolean = false;
    if (a()) {
      this.jdField_d_of_type_AndroidWidgetTextView.setText("0(fps)");
    }
  }
  
  public void a(long paramLong)
  {
    if (a()) {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramLong + "(fps)");
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131492941;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1024) && (paramInt2 == -1)) {
      a(paramIntent.getExtras().getString("take_photo_path"));
    }
  }
  
  public void onBackPressed()
  {
    getActivity().finish();
  }
  
  public void onClick(View paramView)
  {
    if (bhcp.a(paramView)) {
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131298198: 
      onBackPressed();
      return;
    case 2131305123: 
      g();
      if (!this.jdField_f_of_type_Boolean)
      {
        bhci.a().r();
        return;
      }
      bhci.a().s();
      return;
    case 2131303311: 
      a(this.g);
      bhci.a().t();
      return;
    }
    d();
  }
  
  public void onDestroy()
  {
    QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---onDestroy");
    r();
    super.onDestroy();
    j();
    BitmapUtils.recycle(this.jdField_a_of_type_AndroidGraphicsBitmap);
    if (QLog.isDebugVersion()) {
      QLog.d("AETemplateInfoFragment", 4, "submit clear temp files task");
    }
    ThreadManagerV2.excute(new AETemplateInfoFragment.2(this), 64, null, false);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (paramIntent == null) {}
    while (paramIntent.getIntExtra("pic_result_back_type", -1) != 0) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList = paramIntent.getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
    if ((b()) && (!this.jdField_e_of_type_Boolean))
    {
      k();
      return;
    }
    m();
  }
  
  public void onPause()
  {
    QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---onPause");
    super.onPause();
    this.jdField_a_of_type_Boolean = false;
    s();
  }
  
  public void onResume()
  {
    QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---onResume");
    super.onResume();
    t();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    this.vg.setTitle("模板详情");
    if ((!FeatureManager.Features.PAG.init()) || (!FeatureManager.Features.MEDIA.init()))
    {
      bhcs.b("AETemplateInfoFragment", 1, "pag相关so未初始化成功");
      bbmy.a(getActivity(), "pag相关so未初始化成功", 0).a();
      return;
    }
    c();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.AECamera.qudong.AETemplateInfoFragment
 * JD-Core Version:    0.7.0.1
 */