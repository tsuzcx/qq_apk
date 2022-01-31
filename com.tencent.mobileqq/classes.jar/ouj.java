import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.basic.ReadInJoyDynamicChannelBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.cgi.ReadInJoyCGIDynamicChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.compat.ReadInJoyDynamicChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBBCircleFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyFollowFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyRecommendFeedsFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySelfFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySubChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyTribeChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyVideoChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyViolaChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class ouj
{
  static ouj jdField_a_of_type_Ouj;
  String jdField_a_of_type_JavaLangString = "ReadInJoyFragmentFactory";
  WeakReference<ReadInJoyNewFeedsActivity> jdField_a_of_type_MqqUtilWeakReference = null;
  
  public static ReadInJoyBaseFragment a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return ReadInJoyRecommendFeedsFragment.a();
    case 1: 
      ReadInJoyVideoChannelFragment localReadInJoyVideoChannelFragment = new ReadInJoyVideoChannelFragment();
      localReadInJoyVideoChannelFragment.b(1002);
      return localReadInJoyVideoChannelFragment;
    case 2: 
      return ReadInJoyFollowFragment.a();
    }
    return new ReadInJoySelfFragment();
  }
  
  public static ouj a()
  {
    try
    {
      if (jdField_a_of_type_Ouj == null) {
        jdField_a_of_type_Ouj = new ouj();
      }
      return jdField_a_of_type_Ouj;
    }
    finally {}
  }
  
  public Fragment a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramTabChannelCoverInfo == null)
    {
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "tabChannelCoverInfo is null.");
      paramTabChannelCoverInfo = (TabChannelCoverInfo)localObject2;
      return paramTabChannelCoverInfo;
    }
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "new Fragment, channelName = ", paramTabChannelCoverInfo.mChannelCoverName, ", channelID = ", Integer.valueOf(paramTabChannelCoverInfo.mChannelCoverId) });
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "ReadInJoyConstnats.RECOMMEND= 0");
    if (paramTabChannelCoverInfo.mChannelCoverId == ozy.a()) {
      localObject1 = ReadInJoyRecommendFeedsFragment.a();
    }
    for (;;)
    {
      paramTabChannelCoverInfo = (TabChannelCoverInfo)localObject1;
      if (!(localObject1 instanceof ReadInJoyBaseFragment)) {
        break;
      }
      ((ReadInJoyBaseFragment)localObject1).b(true);
      return localObject1;
      switch (paramTabChannelCoverInfo.mChannelCoverId)
      {
      default: 
        if (rvx.a(paramTabChannelCoverInfo.mChannelJumpUrl))
        {
          localObject1 = ReadInJoyViolaChannelFragment.a(paramTabChannelCoverInfo.mChannelCoverId, paramTabChannelCoverInfo.mChannelCoverName, paramTabChannelCoverInfo.mChannelVersion);
          ((ReadInJoyViolaChannelFragment)localObject1).a(paramTabChannelCoverInfo.mChannelJumpUrl);
        }
        break;
      case 0: 
        localObject1 = ReadInJoyRecommendFeedsFragment.a();
        break;
      case 56: 
        localObject1 = new ReadInJoyVideoChannelFragment();
        ((ReadInJoyVideoChannelFragment)localObject1).b(1003);
        break;
      case 70: 
        localObject1 = new ReadInJoyBBCircleFragment();
        break;
      case 41522: 
        localObject1 = new ReadInJoyPicWaterFallFragment();
        break;
      case 41450: 
        localObject1 = new ReadInJoyTribeChannelFragment();
        continue;
        if (paramTabChannelCoverInfo.bid > 0L)
        {
          localObject2 = ReadInJoyDynamicChannelBaseFragment.a(ReadInJoyDynamicChannelBaseFragment.a(paramTabChannelCoverInfo.mChannelCoverId));
          if (localObject2 != null)
          {
            localObject2 = ((rpr)localObject2).a();
            if (localObject2 == null) {
              continue;
            }
            if (!TextUtils.isEmpty(((oqj)localObject2).b("cgi"))) {}
            for (paramTabChannelCoverInfo = ReadInJoyCGIDynamicChannelFragment.a(paramTabChannelCoverInfo.mChannelCoverId, 0, paramTabChannelCoverInfo.mChannelCoverName);; paramTabChannelCoverInfo = ReadInJoyDynamicChannelFragment.a(paramTabChannelCoverInfo.mChannelCoverId, 0, paramTabChannelCoverInfo.mChannelCoverName))
            {
              localObject1 = paramTabChannelCoverInfo;
              break;
            }
          }
        }
        localObject1 = ReadInJoySubChannelFragment.a(paramTabChannelCoverInfo.mChannelCoverId, paramTabChannelCoverInfo.mChannelType, paramTabChannelCoverInfo.mChannelCoverName);
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference != null)
    {
      this.jdField_a_of_type_MqqUtilWeakReference.clear();
      this.jdField_a_of_type_MqqUtilWeakReference = null;
    }
  }
  
  public void a(ReadInJoyNewFeedsActivity paramReadInJoyNewFeedsActivity)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramReadInJoyNewFeedsActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ouj
 * JD-Core Version:    0.7.0.1
 */