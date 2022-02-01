import com.tencent.av.VideoController;
import com.tencent.av.ui.MultiMembersAudioUI;
import com.tencent.av.ui.MultiVideoEnterPageActivity;
import java.util.ArrayList;

public class mgf
  extends ldz
{
  public mgf(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity) {}
  
  protected void a(int paramInt)
  {
    if (this.a.b()) {
      return;
    }
    this.a.c(paramInt);
  }
  
  protected void a(long paramLong, ArrayList<lcp> paramArrayList, int paramInt1, int paramInt2)
  {
    if (this.a.b()) {
      return;
    }
    this.a.a(paramLong, paramArrayList, paramInt1, paramInt2);
  }
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    if (this.a.b()) {}
    do
    {
      do
      {
        return;
      } while (paramLong != this.a.jdField_a_of_type_Long);
      if (paramBoolean)
      {
        this.a.b(paramInt);
        return;
      }
    } while (((paramInt != 10) && (paramInt != 1)) || (!MultiVideoEnterPageActivity.a(this.a)));
    this.a.a(paramInt);
  }
  
  protected void e()
  {
    if (this.a.b()) {}
    while (this.a.jdField_a_of_type_Boolean) {
      return;
    }
    super.e();
    ArrayList localArrayList = this.a.jdField_a_of_type_ComTencentAvVideoController.e();
    localArrayList = this.a.jdField_a_of_type_ComTencentAvVideoController.a(localArrayList.size(), localArrayList);
    this.a.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mgf
 * JD-Core Version:    0.7.0.1
 */