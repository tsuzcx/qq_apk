import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class tfv
  extends JobSegment<tff, List<tso>>
{
  public String a;
  public twz a;
  public boolean a;
  public String b = "";
  public String c;
  
  public tfv(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.c = paramString;
  }
  
  public tfv(String paramString1, String paramString2, String paramString3, twz paramtwz)
  {
    this(paramString1);
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.b = paramString3;
    this.jdField_a_of_type_Twz = paramtwz;
  }
  
  public static List<tso> a(List<tfx> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      tfx localtfx = (tfx)paramList.next();
      if ((!TextUtils.isEmpty(localtfx.b)) && (!TextUtils.isEmpty(localtfx.jdField_a_of_type_JavaLangString)))
      {
        tso localtso = new tso();
        localtso.jdField_a_of_type_JavaLangString = localtfx.b;
        localtso.b = localtfx.jdField_a_of_type_JavaLangString;
        localtso.jdField_a_of_type_Long = localtfx.jdField_a_of_type_Long;
        localtso.jdField_a_of_type_Boolean = localtfx.jdField_a_of_type_Boolean;
        localArrayList.add(localtso);
      }
    }
    return localArrayList;
  }
  
  protected void a(JobContext paramJobContext, tff paramtff)
  {
    if (paramtff == null)
    {
      ved.d("Q.qqstory.msgTab.jobPullVidList", "(0) runSegment() from: nodeInfo is null!");
      vxp.a("nodeInfo is null!", new Object[0]);
      notifyResult(new ArrayList());
      return;
    }
    ved.b("Q.qqstory.msgTab.jobPullVidList", "(1) runSegment() from: %s, uid: %s, cookie: %s, startVid: %s, groupdId: %s, nodeInfoList.size: %d, passthrough: %s", new Object[] { this.c, paramtff.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Twz, Integer.valueOf(paramtff.jdField_a_of_type_JavaUtilList.size()), paramtff.k });
    if (TextUtils.isEmpty(paramtff.jdField_a_of_type_JavaLangString))
    {
      notifyError(new ErrorMessage(100, "nodeInfo not valid"));
      return;
    }
    if ((paramtff.jdField_a_of_type_JavaUtilList.size() == 0) && (paramtff.jdField_a_of_type_Int != 12))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.jobPullVidList", 2, new Object[] { "skip, nodeInfo has no video, info=%s", paramtff });
      }
      if (paramtff.jdField_a_of_type_Int == 5)
      {
        notifyResult(new ArrayList());
        return;
      }
      notifyError(new ErrorMessage(100, "vid is 0"));
      return;
    }
    if ((paramtff.a()) && (paramtff.jdField_a_of_type_Int != 12))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.jobPullVidList", 2, new Object[] { "video list had preloaded, info=%s", paramtff });
      }
      notifyResult(a(paramtff.jdField_a_of_type_JavaUtilList));
      return;
    }
    paramJobContext = null;
    if (paramtff.jdField_a_of_type_Int != 12) {
      paramJobContext = tfy.a(paramtff);
    }
    if (paramJobContext != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.jobPullVidList", 2, "get succeed from db, info=" + paramtff);
      }
      ved.b("Q.qqstory.msgTab.jobPullVidList", "(2) runSegment(), try decode cached rsp from DB");
      paramJobContext = tgl.a(paramtff, paramJobContext);
      if (paramJobContext != null)
      {
        paramJobContext = a(paramJobContext.a.jdField_a_of_type_JavaUtilList);
        notifyResult(paramJobContext);
        ved.a("Q.qqstory.msgTab.jobPullVidList", "(end) runSegment(), Segment notifyResult(), size=%d", Integer.valueOf(paramJobContext.size()));
        return;
      }
      ved.b("Q.qqstory.msgTab.jobPullVidList", "(2-1) runSegment(), decode cached rsp from DB fail, start to pull vid list instead");
    }
    if (this.jdField_a_of_type_Boolean)
    {
      ved.b("Q.qqstory.msgTab.jobPullVidList", "(2) runSegment(), isLocal Only return null");
      notifyResult(new ArrayList());
      return;
    }
    if ((this.jdField_a_of_type_Twz != null) && (this.jdField_a_of_type_Twz.jdField_a_of_type_Boolean))
    {
      ved.b("Q.qqstory.msgTab.jobPullVidList", "(2) runSegment(), groupId is end, won't request anymore!");
      notifyResult(new ArrayList());
      return;
    }
    ved.b("Q.qqstory.msgTab.jobPullVidList", "(2) runSegment(), start to pull vid list");
    paramJobContext = new tgl(paramtff, this.jdField_a_of_type_JavaLangString, this.b);
    ved.a("Q.qqstory.msgTab.jobPullVidList", "(3) runSegment(), sendCmd: %s", paramJobContext);
    if ((paramtff.jdField_a_of_type_Int == 12) && (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      ved.b("Q.qqstory.msgTab.jobPullVidList", "(3-1) runSegment() weishi node, cookie is empty, clear list");
      paramtff.jdField_a_of_type_JavaUtilList.clear();
    }
    syo.a().a(paramJobContext, new tfw(this, paramtff));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tfv
 * JD-Core Version:    0.7.0.1
 */