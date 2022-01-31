import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyCapsuleView;
import com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyFeedsHeaderViewController.3;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.HotSearchItem;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class roj
  extends rnv
  implements View.OnClickListener
{
  protected static int a;
  private static Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#F1F3F6"));
  private static int jdField_b_of_type_Int = Color.parseColor("#47000000");
  public akiz a;
  protected akjb a;
  protected BroadcastReceiver a;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private ReadInJoyCapsuleView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView;
  private URLDrawableDownListener jdField_a_of_type_ComTencentImageURLDrawableDownListener = new roo(this);
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  public HotWordSearchEntryDataModel a;
  protected String a;
  private osm jdField_a_of_type_Osm = new rok(this);
  private rop jdField_a_of_type_Rop;
  private sec jdField_a_of_type_Sec;
  public boolean a;
  private ReadInJoyCapsuleView jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView;
  private rop jdField_b_of_type_Rop;
  protected boolean b;
  private ReadInJoyCapsuleView jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView;
  private rop jdField_c_of_type_Rop;
  
  public roj(Context paramContext)
  {
    this.jdField_a_of_type_Akjb = new rol(this);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new rom(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559932, null);
    Object localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131377216);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView = ((ReadInJoyCapsuleView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363876));
    this.jdField_a_of_type_Rop = new rop(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView = ((ReadInJoyCapsuleView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363875));
    this.jdField_b_of_type_Rop = new rop(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView = ((ReadInJoyCapsuleView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363874));
    this.jdField_c_of_type_Rop = new rop(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368594));
    a(a(osg.a().a(0)));
    ((View)localObject).setOnClickListener(this);
    osj.a().a(this.jdField_a_of_type_Osm);
    ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).addObserver(this.jdField_a_of_type_Akjb);
    g();
    localObject = new IntentFilter("mqq.intent.action.ACCOUNT_CHANGED");
    paramContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
  }
  
  private URLDrawable a(ChannelCoverInfo paramChannelCoverInfo, boolean paramBoolean)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = paramBoolean;
    paramChannelCoverInfo = URLDrawable.getDrawable(seb.a(paramChannelCoverInfo.externalExposureBackgroundUrl), (URLDrawable.URLDrawableOptions)localObject);
    if ((paramChannelCoverInfo.getCurrDrawable() instanceof GifDrawable))
    {
      localObject = ((GifDrawable)paramChannelCoverInfo.getCurrDrawable()).getImage();
      if (paramBoolean) {
        break label57;
      }
      paramChannelCoverInfo.setIndividualPause(true);
    }
    for (;;)
    {
      ((AbstractGifImage)localObject).reset();
      return paramChannelCoverInfo;
      label57:
      paramChannelCoverInfo.setIndividualPause(false);
    }
  }
  
  private static <T> Iterable<T> a(Iterable<T> paramIterable)
  {
    Object localObject = paramIterable;
    if (paramIterable == null) {
      localObject = Collections.emptyList();
    }
    return localObject;
  }
  
  private List<ChannelCoverInfo> a(List<ChannelCoverInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = a(paramList).iterator();
    while (localIterator.hasNext())
    {
      ChannelCoverInfo localChannelCoverInfo = (ChannelCoverInfo)localIterator.next();
      if ((localChannelCoverInfo.isExternalExposure) && (((bhvy.i()) && (!bhvy.j())) || (localChannelCoverInfo.mChannelCoverId != 56)))
      {
        paramList = localChannelCoverInfo.externalExposureBackgroundUrl;
        if ((!TextUtils.isEmpty(paramList)) && (!TextUtils.equals(bhvy.d(localChannelCoverInfo.mChannelCoverId), paramList)))
        {
          if (localChannelCoverInfo.isExternalExposurePersist) {
            paramList = "";
          }
          bhvy.a(paramList, localChannelCoverInfo.mChannelCoverId);
          bhvy.a(localChannelCoverInfo.mChannelCoverId, false);
        }
        localArrayList.add(localChannelCoverInfo);
      }
    }
    return localArrayList;
  }
  
  private void a(ChannelCoverInfo paramChannelCoverInfo)
  {
    URLDrawable localURLDrawable = a(paramChannelCoverInfo, true);
    if (localURLDrawable.getStatus() == 1)
    {
      if ((localURLDrawable.getCurrDrawable() instanceof GifDrawable))
      {
        AbstractGifImage localAbstractGifImage = ((GifDrawable)localURLDrawable.getCurrDrawable()).getImage();
        if ((localAbstractGifImage instanceof sec))
        {
          this.jdField_a_of_type_Sec = ((sec)localAbstractGifImage);
          ((sec)localAbstractGifImage).a(new ron(this, paramChannelCoverInfo));
        }
      }
      this.jdField_a_of_type_ComTencentImageURLDrawableDownListener.onLoadSuccessed(this.jdField_a_of_type_ComTencentImageURLImageView, localURLDrawable);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(localURLDrawable);
      this.jdField_a_of_type_ComTencentImageURLImageView.setTag(paramChannelCoverInfo);
      this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this);
      return;
      localURLDrawable.startDownload();
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("is_pic", i);
        a(paramString, localJSONObject);
        return;
      }
      catch (JSONException paramString)
      {
        throw new IllegalArgumentException("fail to construct json object");
      }
    }
  }
  
  private void a(List<ChannelCoverInfo> paramList)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView.setVisibility(8);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView.setVisibility(8);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView.setVisibility(8);
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    Iterator localIterator = paramList.iterator();
    label170:
    while (localIterator.hasNext())
    {
      ChannelCoverInfo localChannelCoverInfo = (ChannelCoverInfo)localIterator.next();
      ReadInJoyCapsuleView localReadInJoyCapsuleView;
      if (localChannelCoverInfo.mChannelCoverId == 56)
      {
        localReadInJoyCapsuleView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView;
        paramList = this.jdField_a_of_type_Rop;
      }
      for (;;)
      {
        if (localReadInJoyCapsuleView == null) {
          break label170;
        }
        localReadInJoyCapsuleView.setVisibility(0);
        localReadInJoyCapsuleView.setText(localChannelCoverInfo.mChannelCoverName);
        paramList.a(localChannelCoverInfo, this);
        break;
        if (localChannelCoverInfo.mChannelCoverId == 1000000)
        {
          localReadInJoyCapsuleView = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView;
          paramList = this.jdField_b_of_type_Rop;
        }
        else if (localChannelCoverInfo.mChannelCoverId == 2000000)
        {
          a(localChannelCoverInfo);
          paramList = null;
          localReadInJoyCapsuleView = null;
        }
        else
        {
          localReadInJoyCapsuleView = this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView;
          paramList = this.jdField_c_of_type_Rop;
        }
      }
    }
  }
  
  private static int b(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      switch (paramInt)
      {
      default: 
        return 0;
      case 56: 
        return 2130842357;
      }
      return 2130842353;
    }
    switch (paramInt)
    {
    default: 
      return 0;
    case 56: 
      return 2130842356;
    }
    return 2130842352;
  }
  
  public void a()
  {
    QLog.d("ReadInJoyFeedsHeaderVie", 2, "reportExposure");
    if (this.jdField_a_of_type_Rop.a() != null) {
      a("0X8008B88", this.jdField_a_of_type_Rop.a());
    }
    if (this.jdField_b_of_type_Rop.a() != null) {
      a("0X8008B89", this.jdField_b_of_type_Rop.a());
    }
  }
  
  public void a(ListView paramListView)
  {
    paramListView.addHeaderView(this.jdField_a_of_type_AndroidViewView);
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = false;
    osj.a().b(this.jdField_a_of_type_Osm);
    this.jdField_a_of_type_Rop.b();
    this.jdField_b_of_type_Rop.b();
    this.jdField_c_of_type_Rop.b();
    ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).removeObserver(this.jdField_a_of_type_Akjb);
    this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Sec != null) {
      this.jdField_a_of_type_Sec.a();
    }
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_b_of_type_Boolean = false;
    }
    for (;;)
    {
      AbstractGifImage.resumeAll();
      return;
      f();
    }
  }
  
  public void d() {}
  
  public void f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel == null) || (this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.a == null) || (this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.a.size() == 0)) {
      return;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.a.size();
    this.jdField_a_of_type_JavaLangString = ((HotWordSearchEntryDataModel.HotSearchItem)this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.a.get(jdField_a_of_type_Int % i)).title;
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377216)).setText(this.jdField_a_of_type_JavaLangString);
    jdField_a_of_type_Int += 1;
  }
  
  protected void g()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (!TextUtils.isEmpty(amvl.a().jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel = new HotWordSearchEntryDataModel(localQQAppInterface, 1, 6, false);
      ThreadManager.post(new ReadInJoyFeedsHeaderViewController.3(this, localQQAppInterface), 5, null, true);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131377216: 
      onh.d(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
      awsq.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), new ReportModelDC02528().opername("Kdian_inner_search").module("kd_web_search").action("active_search").ver1(this.jdField_a_of_type_JavaLangString).ver7("{experiment_id:" + awsq.b + "}"));
      return;
    case 2131363876: 
      paramView = this.jdField_a_of_type_Rop.a();
      localObject = new HashMap();
      ((HashMap)localObject).put("param_key_ariticle_id", Long.valueOf(paramView.mArticleId));
      ((HashMap)localObject).put("param_key_channel_cover_style", Integer.valueOf(paramView.mChannelCoverStyle));
      nuq.a(this.jdField_a_of_type_AndroidContentContext, paramView.mChannelCoverId, paramView.mChannelCoverName, paramView.mChannelType, 4, (Map)localObject);
      a("0X8008B84", this.jdField_a_of_type_Rop.a());
      return;
    case 2131363875: 
      this.jdField_b_of_type_Rop.a();
      rvx.a(this.jdField_a_of_type_AndroidContentContext, ajya.a(2131713030), "https://kandian.qq.com/viola/bundle_hotTopic.js?v_bid=3256&statusColor=1", null);
      a("0X8008B85", this.jdField_b_of_type_Rop.a());
      return;
    }
    Object localObject = (ChannelCoverInfo)paramView.getTag();
    onh.a(paramView.getContext(), ((ChannelCoverInfo)localObject).mChannelJumpUrl);
    a("0X800920D", new JSONObject());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     roj
 * JD-Core Version:    0.7.0.1
 */