import com.tencent.av.wtogether.data.ReqVideoAction;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import trpc.qq_av_together.common.WTogetherCommon.Result;

public class myo
{
  public final int a;
  public final long a;
  public ReqVideoAction a;
  public String a;
  public boolean a;
  public int b;
  
  public myo(int paramInt, long paramLong)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Boolean = false;
    this.b = -1;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentAvWtogetherDataReqVideoAction = null;
  }
  
  public myo(int paramInt, long paramLong, ReqVideoAction paramReqVideoAction)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Boolean = false;
    this.b = -1;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentAvWtogetherDataReqVideoAction = paramReqVideoAction;
  }
  
  public void a(WTogetherCommon.Result paramResult)
  {
    if (paramResult != null)
    {
      this.b = paramResult.errcode.get();
      if (paramResult == null) {
        break label53;
      }
      this.jdField_a_of_type_JavaLangString = paramResult.errmsg.get();
      label30:
      if (this.b != 0) {
        break label61;
      }
    }
    label53:
    label61:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
      this.b = -1;
      break;
      this.jdField_a_of_type_JavaLangString = null;
      break label30;
    }
  }
  
  public String toString()
  {
    return "ComResult{from: " + this.jdField_a_of_type_Int + ", roomId: " + this.jdField_a_of_type_Long + ", isSuccess: " + this.jdField_a_of_type_Boolean + ", errCode: " + this.b + ", errMsg: " + this.jdField_a_of_type_JavaLangString + ", action: " + this.jdField_a_of_type_ComTencentAvWtogetherDataReqVideoAction + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     myo
 * JD-Core Version:    0.7.0.1
 */