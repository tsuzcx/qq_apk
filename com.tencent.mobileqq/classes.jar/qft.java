import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsResourceLoader.1;
import com.tencent.biz.pubaccount.readinjoy.view.LayoutInflateProcessor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class qft
{
  private static int jdField_a_of_type_Int;
  private static LayoutInflateProcessor jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor;
  private static HashMap<Integer, Drawable> jdField_a_of_type_JavaUtilHashMap;
  private Handler jdField_a_of_type_AndroidOsHandler;
  
  public qft(Context paramContext)
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor = new LayoutInflateProcessor(paramContext.getApplicationContext());
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    jdField_a_of_type_Int += 1;
    a(paramContext);
  }
  
  public static Drawable a(Context paramContext, int paramInt)
  {
    if (jdField_a_of_type_JavaUtilHashMap == null) {}
    do
    {
      return null;
      if (jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
        return (Drawable)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
      }
      try
      {
        paramContext = paramContext.getResources().getDrawable(paramInt);
        jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), paramContext);
        return paramContext;
      }
      catch (OutOfMemoryError paramContext) {}
    } while (!QLog.isColorLevel());
    QLog.d("VideoFeedsResourceLoader", 2, "innerGetDrawableFromCache() OutOfMemoryError e=" + paramContext.getMessage());
    return null;
  }
  
  public static View a(int paramInt, boolean paramBoolean, ViewGroup.LayoutParams paramLayoutParams)
  {
    View localView = null;
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor != null) {
      localView = jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor.a(paramInt, paramBoolean, paramLayoutParams);
    }
    while (!paramBoolean) {
      return localView;
    }
    localView = LayoutInflater.from(BaseApplicationImpl.getContext()).inflate(paramInt, null, false);
    localView.setLayoutParams(paramLayoutParams);
    return localView;
  }
  
  public static LayoutInflateProcessor a()
  {
    return jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor;
  }
  
  private qny a()
  {
    return new qny(2131494494, null, new qfu(this));
  }
  
  private qny a(int paramInt, Activity paramActivity)
  {
    return new qny(2131494497, paramInt, null, new qfv(this, paramActivity));
  }
  
  private void a(Context paramContext)
  {
    ThreadManager.excute(new VideoFeedsResourceLoader.1(this, paramContext), 16, null, true);
  }
  
  public void a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor != null) {
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor.a();
    }
    if (jdField_a_of_type_JavaUtilHashMap != null) {
      jdField_a_of_type_JavaUtilHashMap.clear();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    jdField_a_of_type_Int -= 1;
    if (jdField_a_of_type_Int <= 0)
    {
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor = null;
      jdField_a_of_type_JavaUtilHashMap = null;
    }
  }
  
  public void a(int paramInt, Activity paramActivity)
  {
    if (paramInt == 0) {}
    for (qny localqny1 = new qny(2131494514, null, null);; localqny1 = null)
    {
      qny localqny2 = new qny(2131494272, null, null);
      qny localqny3 = new qny(2131494438, null, null);
      qny localqny4 = a(1, paramActivity);
      qny localqny5 = a();
      paramActivity = a(2, paramActivity);
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor.a(new qny[] { localqny1, localqny2, localqny3, localqny4, localqny5, paramActivity });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qft
 * JD-Core Version:    0.7.0.1
 */