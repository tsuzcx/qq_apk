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

public class ssf
  extends RecyclerView.Adapter<srn>
  implements IEventReceiver, srt
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private List<sqb> jdField_a_of_type_JavaUtilList = new ArrayList();
  private spq jdField_a_of_type_Spq = (spq)tdc.a(30);
  private ssg jdField_a_of_type_Ssg;
  private ssh jdField_a_of_type_Ssh;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  private int d;
  private int e = -1;
  
  public ssf(Activity paramActivity, ssh paramssh, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.b = paramInt2;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Ssh = paramssh;
    this.jdField_a_of_type_Ssg = new ssg(this);
    this.jdField_a_of_type_JavaUtilList.add(sqb.a(1));
    if (!this.jdField_a_of_type_Spq.a()) {
      this.jdField_a_of_type_JavaUtilList.add(sqb.a(3));
    }
    this.jdField_a_of_type_Boolean = true;
    ste.a().registerSubscriber(this.jdField_a_of_type_Ssg);
  }
  
  private void a(List<sqb> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    vel.a("video_shoot_slides", "number_smartalbum", 0, 0, new String[] { "", paramList.size() + "" });
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      sqb localsqb = (sqb)paramList.next();
      if (localsqb.a() == 1) {
        localArrayList1.add(localsqb);
      } else {
        localArrayList2.add(localsqb);
      }
    }
    vel.a("video_shoot_slides", "read_smartalbum", 0, 0, new String[] { spq.a(localArrayList1) + "", localArrayList1.size() + "" });
    vel.a("video_shoot_slides", "unread_smartalbum", 0, 0, new String[] { spq.a(localArrayList2) + "", localArrayList2.size() + "" });
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        if (!((sqb)localIterator.next()).a()) {
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
  
  public int a(sqb paramsqb)
  {
    return this.jdField_a_of_type_JavaUtilList.indexOf(paramsqb);
  }
  
  public List<sqb> a()
  {
    return Collections.unmodifiableList(this.jdField_a_of_type_JavaUtilList);
  }
  
  public sqb a()
  {
    if ((this.e >= 0) && (this.e < getItemCount())) {
      return (sqb)this.jdField_a_of_type_JavaUtilList.get(this.e);
    }
    return null;
  }
  
  public srn a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131561202, paramViewGroup, false);
    return new srn(this.jdField_a_of_type_AndroidAppActivity, paramViewGroup, this.jdField_a_of_type_Int, this.b, this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    ste.a().unRegisterSubscriber(this.jdField_a_of_type_Ssg);
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
  
  public void a(sqb paramsqb)
  {
    long l = SystemClock.uptimeMillis();
    if (l - this.jdField_a_of_type_Long > 500L) {
      if ((!paramsqb.b()) && (this.jdField_a_of_type_JavaUtilList.indexOf(paramsqb) >= 0) && (paramsqb == a()) && (this.jdField_a_of_type_Ssh != null)) {
        this.jdField_a_of_type_Ssh.a(paramsqb);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Long = l;
      return;
      veg.d("Q.qqstory.recommendAlbum.ui.AlbumVideoGalleryAdapter", "you click too fast, wait...");
    }
  }
  
  public void a(srn paramsrn, int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) {}
    do
    {
      return;
      paramsrn.a((sqb)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    } while (((this.e != -1) || (paramInt == 0)) && (this.e == paramInt));
    srv.a(paramsrn, this.c, this.jdField_a_of_type_Int, this.d, this.b, 0.0F, paramInt);
  }
  
  public boolean a(@NonNull List<sqb> paramList)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        if (!((sqb)localIterator.next()).a()) {
          return false;
        }
      }
    }
    if (paramList.size() > 0)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_JavaUtilList.add(sqb.a(1));
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      notifyDataSetChanged();
    }
    for (;;)
    {
      this.jdField_a_of_type_Ssh.e();
      a(paramList);
      return true;
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_JavaUtilList.add(sqb.a(1));
      this.jdField_a_of_type_JavaUtilList.add(sqb.a(4));
      notifyDataSetChanged();
    }
  }
  
  public void b()
  {
    if (a()) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(sqb.a(1));
    this.jdField_a_of_type_JavaUtilList.add(sqb.a(2));
    notifyDataSetChanged();
    this.jdField_a_of_type_Ssh.e();
  }
  
  public void b(RecyclerView paramRecyclerView, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getItemCount()))
    {
      paramRecyclerView = (srn)paramRecyclerView.findViewHolderForAdapterPosition(paramInt);
      if (paramRecyclerView != null) {
        paramRecyclerView.a();
      }
    }
  }
  
  public void b(sqb paramsqb)
  {
    int j = a(paramsqb);
    if (j >= 0)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramsqb);
      if (this.jdField_a_of_type_JavaUtilList.size() <= 0) {
        break label188;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (((sqb)localIterator.next()).a());
    }
    label188:
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        veg.b("Q.qqstory.recommendAlbum.ui.AlbumVideoGalleryAdapter", "album delete all , show empty page");
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
        this.jdField_a_of_type_JavaUtilList.add(sqb.a(1));
        this.jdField_a_of_type_JavaUtilList.add(sqb.a(4));
      }
      notifyItemRemoved(j);
      if (j < this.jdField_a_of_type_JavaUtilList.size()) {
        notifyItemRangeChanged(j, this.jdField_a_of_type_JavaUtilList.size() - j);
      }
      if (this.jdField_a_of_type_Ssh != null) {
        this.jdField_a_of_type_Ssh.a(paramsqb, j);
      }
      this.jdField_a_of_type_Spq.a(paramsqb.a());
      return;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(sqb.a(1));
    this.jdField_a_of_type_JavaUtilList.add(sqb.a(3));
    notifyDataSetChanged();
    this.jdField_a_of_type_Ssh.e();
  }
  
  public void c(sqb paramsqb)
  {
    b(paramsqb);
    vel.a("video_shoot_slides", "delete_smartalbum", 0, 0, new String[] { String.valueOf(paramsqb.d()), "2" });
  }
  
  public void d()
  {
    if (a()) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(sqb.a(1));
    this.jdField_a_of_type_JavaUtilList.add(sqb.a(5));
    notifyDataSetChanged();
    this.jdField_a_of_type_Ssh.e();
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
 * Qualified Name:     ssf
 * JD-Core Version:    0.7.0.1
 */