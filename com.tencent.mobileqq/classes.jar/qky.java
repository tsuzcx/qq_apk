import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.List;

public class qky
  extends RecyclerView.Adapter<qla>
  implements qkw, qkx
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private VideoFeedsRecyclerView jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ArrayList<VideoInfo> jdField_a_of_type_JavaUtilArrayList;
  private qkz jdField_a_of_type_Qkz;
  
  public qky(VideoFeedsRecyclerView paramVideoFeedsRecyclerView, ArrayList<VideoInfo> paramArrayList, Activity paramActivity, QQAppInterface paramQQAppInterface, qkz paramqkz)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = paramVideoFeedsRecyclerView;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Qkz = paramqkz;
  }
  
  private void a(RecyclerView paramRecyclerView, List<VideoInfo> paramList, int paramInt)
  {
    int j = paramRecyclerView.getChildCount();
    int i = 0;
    while (i < j)
    {
      RecyclerView.ViewHolder localViewHolder = paramRecyclerView.getChildViewHolder(paramRecyclerView.getChildAt(i));
      if ((localViewHolder instanceof qla))
      {
        VideoInfo localVideoInfo = (VideoInfo)paramList.get(((qla)localViewHolder).a);
        if ((localVideoInfo.e()) && (localVideoInfo.a.a == paramInt)) {
          ((qla)localViewHolder).d();
        }
      }
      i += 1;
    }
  }
  
  private boolean a(RecyclerView paramRecyclerView, List<VideoInfo> paramList, VideoInfo paramVideoInfo)
  {
    int j = paramRecyclerView.getChildCount();
    int k = paramList.indexOf(paramVideoInfo);
    int i = 0;
    while (i < j)
    {
      paramList = paramRecyclerView.getChildViewHolder(paramRecyclerView.getChildAt(i));
      if ((k >= 0) && ((paramList instanceof qla)) && (((qla)paramList).a == k))
      {
        ((qla)paramList).d();
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private boolean a(RecyclerView paramRecyclerView, List<VideoInfo> paramList, String paramString)
  {
    int j = paramRecyclerView.getChildCount();
    int i = 0;
    while (i < j)
    {
      RecyclerView.ViewHolder localViewHolder = paramRecyclerView.getChildViewHolder(paramRecyclerView.getChildAt(i));
      if (((localViewHolder instanceof qla)) && (paramString.equals(((VideoInfo)paramList.get(((qla)localViewHolder).a)).j))) {
        ((qla)localViewHolder).d();
      }
      i += 1;
    }
    return false;
  }
  
  public qla a(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject = null;
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramViewGroup.getContext());
    switch (paramInt)
    {
    default: 
      paramViewGroup = localObject;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Qkz != null) {
        this.jdField_a_of_type_Qkz.a(paramViewGroup);
      }
      return paramViewGroup;
      paramViewGroup = new qlv(localLayoutInflater.inflate(2131494394, paramViewGroup, false), this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      continue;
      paramViewGroup = new noi(localLayoutInflater.inflate(2131494223, paramViewGroup, false), this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public void a(int paramInt)
  {
    VideoInfo localVideoInfo = (VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.getChildCount();
    paramInt = 0;
    for (;;)
    {
      if (paramInt < i)
      {
        Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.getChildViewHolder(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.getChildAt(paramInt));
        if ((localObject instanceof qln))
        {
          localObject = (qln)localObject;
          if (((qln)localObject).a() == localVideoInfo) {
            ((qln)localObject).d();
          }
        }
      }
      else
      {
        return;
      }
      paramInt += 1;
    }
  }
  
  public void a(String paramString)
  {
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_a_of_type_JavaUtilArrayList, paramString);
  }
  
  public void a(qla paramqla, int paramInt)
  {
    paramqla.a = paramInt;
    VideoInfo localVideoInfo = (VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if ((paramqla.b == 0) || (paramqla.b == 1)) {
      paramqla.a(localVideoInfo);
    }
    if (this.jdField_a_of_type_Qkz != null) {
      this.jdField_a_of_type_Qkz.a(paramqla, localVideoInfo, paramInt);
    }
  }
  
  public void b(int paramInt)
  {
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_a_of_type_JavaUtilArrayList, paramInt);
  }
  
  public void b(VideoInfo paramVideoInfo)
  {
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_a_of_type_JavaUtilArrayList, paramVideoInfo);
  }
  
  public void d(VideoInfo paramVideoInfo)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.contains(paramVideoInfo)))
    {
      int i = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramVideoInfo);
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramVideoInfo);
      notifyItemRemoved(i);
    }
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > paramInt) && (((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).c)) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qky
 * JD-Core Version:    0.7.0.1
 */