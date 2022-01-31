import android.app.Activity;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ssc
  extends RecyclerView.Adapter<srk>
  implements IEventReceiver, srq
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private List<spy> jdField_a_of_type_JavaUtilList = new ArrayList();
  private spn jdField_a_of_type_Spn = (spn)tcz.a(30);
  private ssd jdField_a_of_type_Ssd;
  private sse jdField_a_of_type_Sse;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  private int d;
  private int e = -1;
  
  public ssc(Activity paramActivity, sse paramsse, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.b = paramInt2;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Sse = paramsse;
    this.jdField_a_of_type_Ssd = new ssd(this);
    this.jdField_a_of_type_JavaUtilList.add(spy.a(1));
    if (!this.jdField_a_of_type_Spn.a()) {
      this.jdField_a_of_type_JavaUtilList.add(spy.a(3));
    }
    this.jdField_a_of_type_Boolean = true;
    stb.a().registerSubscriber(this.jdField_a_of_type_Ssd);
  }
  
  private void a(List<spy> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    vei.a("video_shoot_slides", "number_smartalbum", 0, 0, new String[] { "", paramList.size() + "" });
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      spy localspy = (spy)paramList.next();
      if (localspy.a() == 1) {
        localArrayList1.add(localspy);
      } else {
        localArrayList2.add(localspy);
      }
    }
    vei.a("video_shoot_slides", "read_smartalbum", 0, 0, new String[] { spn.a(localArrayList1) + "", localArrayList1.size() + "" });
    vei.a("video_shoot_slides", "unread_smartalbum", 0, 0, new String[] { spn.a(localArrayList2) + "", localArrayList2.size() + "" });
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        if (!((spy)localIterator.next()).a()) {
          return true;
        }
      }
    }
    return false;
  }
  
  public int a()
  {
    return this.e;
  }
  
  public int a(spy paramspy)
  {
    return this.jdField_a_of_type_JavaUtilList.indexOf(paramspy);
  }
  
  public List<spy> a()
  {
    return Collections.unmodifiableList(this.jdField_a_of_type_JavaUtilList);
  }
  
  public spy a()
  {
    if ((this.e >= 0) && (this.e < getItemCount())) {
      return (spy)this.jdField_a_of_type_JavaUtilList.get(this.e);
    }
    return null;
  }
  
  public srk a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131561201, paramViewGroup, false);
    return new srk(this.jdField_a_of_type_AndroidAppActivity, paramViewGroup, this.jdField_a_of_type_Int, this.b, this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Ssd);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.d = paramInt2;
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getItemCount()))
    {
      int i = this.e;
      this.e = paramInt;
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.recommendAlbum.ui.AlbumVideoGalleryAdapter", 2, "setSelectPos " + paramInt + " oldPos:" + i);
      }
      b(paramRecyclerView, i);
      b(paramRecyclerView, paramInt);
      b(paramRecyclerView, paramInt - 1);
      b(paramRecyclerView, paramInt + 1);
    }
  }
  
  public void a(spy paramspy)
  {
    long l = SystemClock.uptimeMillis();
    if (l - this.jdField_a_of_type_Long > 500L) {
      if ((!paramspy.b()) && (this.jdField_a_of_type_JavaUtilList.indexOf(paramspy) >= 0) && (paramspy == a()) && (this.jdField_a_of_type_Sse != null)) {
        this.jdField_a_of_type_Sse.a(paramspy);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Long = l;
      return;
      ved.d("Q.qqstory.recommendAlbum.ui.AlbumVideoGalleryAdapter", "you click too fast, wait...");
    }
  }
  
  public void a(srk paramsrk, int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) {}
    do
    {
      return;
      paramsrk.a((spy)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    } while (((this.e != -1) || (paramInt == 0)) && (this.e == paramInt));
    srs.a(paramsrk, this.c, this.jdField_a_of_type_Int, this.d, this.b, 0.0F, paramInt);
  }
  
  public boolean a(@NonNull List<spy> paramList)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        if (!((spy)localIterator.next()).a()) {
          return false;
        }
      }
    }
    if (paramList.size() > 0)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_JavaUtilList.add(spy.a(1));
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      notifyDataSetChanged();
    }
    for (;;)
    {
      this.jdField_a_of_type_Sse.e();
      a(paramList);
      return true;
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_JavaUtilList.add(spy.a(1));
      this.jdField_a_of_type_JavaUtilList.add(spy.a(4));
      notifyDataSetChanged();
    }
  }
  
  public void b()
  {
    if (a()) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(spy.a(1));
    this.jdField_a_of_type_JavaUtilList.add(spy.a(2));
    notifyDataSetChanged();
    this.jdField_a_of_type_Sse.e();
  }
  
  public void b(RecyclerView paramRecyclerView, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getItemCount()))
    {
      paramRecyclerView = (srk)paramRecyclerView.findViewHolderForAdapterPosition(paramInt);
      if (paramRecyclerView != null) {
        paramRecyclerView.a();
      }
    }
  }
  
  public void b(spy paramspy)
  {
    int j = a(paramspy);
    if (j >= 0)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramspy);
      if (this.jdField_a_of_type_JavaUtilList.size() <= 0) {
        break label188;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (((spy)localIterator.next()).a());
    }
    label188:
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        ved.b("Q.qqstory.recommendAlbum.ui.AlbumVideoGalleryAdapter", "album delete all , show empty page");
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
        this.jdField_a_of_type_JavaUtilList.add(spy.a(1));
        this.jdField_a_of_type_JavaUtilList.add(spy.a(4));
      }
      notifyItemRemoved(j);
      if (j < this.jdField_a_of_type_JavaUtilList.size()) {
        notifyItemRangeChanged(j, this.jdField_a_of_type_JavaUtilList.size() - j);
      }
      if (this.jdField_a_of_type_Sse != null) {
        this.jdField_a_of_type_Sse.a(paramspy, j);
      }
      this.jdField_a_of_type_Spn.a(paramspy.a());
      return;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(spy.a(1));
    this.jdField_a_of_type_JavaUtilList.add(spy.a(3));
    notifyDataSetChanged();
    this.jdField_a_of_type_Sse.e();
  }
  
  public void c(spy paramspy)
  {
    b(paramspy);
    vei.a("video_shoot_slides", "delete_smartalbum", 0, 0, new String[] { String.valueOf(paramspy.d()), "2" });
  }
  
  public void d()
  {
    if (a()) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(spy.a(1));
    this.jdField_a_of_type_JavaUtilList.add(spy.a(5));
    notifyDataSetChanged();
    this.jdField_a_of_type_Sse.e();
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ssc
 * JD-Core Version:    0.7.0.1
 */