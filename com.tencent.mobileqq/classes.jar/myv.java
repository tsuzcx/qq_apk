import com.tencent.av.wtogether.data.WTFileInfo;
import com.tencent.qphone.base.util.QLog;

public class myv
{
  public float a;
  public int a;
  public long a;
  public final WTFileInfo a;
  public myu a;
  public long b;
  public long c;
  
  public myv(WTFileInfo paramWTFileInfo)
  {
    this.jdField_a_of_type_ComTencentAvWtogetherDataWTFileInfo = paramWTFileInfo;
    int i = paramWTFileInfo.jdField_a_of_type_Int;
    if (i == 0)
    {
      this.jdField_a_of_type_Myu = null;
      return;
    }
    this.jdField_a_of_type_Myu = new myu(i, paramWTFileInfo.jdField_a_of_type_JavaLangString, paramWTFileInfo.d, paramWTFileInfo.e, paramWTFileInfo.f, paramWTFileInfo.g, paramWTFileInfo.h, paramWTFileInfo.i, paramWTFileInfo.jdField_a_of_type_Long);
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public long a()
  {
    long l4 = System.currentTimeMillis();
    long l3 = this.jdField_a_of_type_Long;
    long l2 = l3;
    long l1;
    if (this.jdField_a_of_type_Int == 0)
    {
      l2 = l3;
      if (this.jdField_a_of_type_Long != 0L)
      {
        l2 = this.b;
        l1 = l3;
        if (this.b != 0L)
        {
          l1 = l3;
          if (l4 - l2 > 0L) {
            l1 = this.jdField_a_of_type_Long + ((float)(l4 - this.b) * this.jdField_a_of_type_Float);
          }
        }
        if (l1 >= this.jdField_a_of_type_Long) {
          break label98;
        }
        l2 = this.jdField_a_of_type_Long;
      }
    }
    label98:
    do
    {
      do
      {
        return l2;
        l2 = l1;
      } while (this.c <= 0L);
      l2 = l1;
    } while (l1 <= this.c);
    return this.c;
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Int != paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WTogetherPlayInfo", 2, "updatePlayState, [" + this.jdField_a_of_type_Int + "-->" + paramInt + "], from[" + paramString + "]");
      }
      this.jdField_a_of_type_Int = paramInt;
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Myu != null) && (this.jdField_a_of_type_Myu.b());
  }
  
  public boolean a(myu parammyu)
  {
    return (this.jdField_a_of_type_Myu != null) && (this.jdField_a_of_type_Myu.a(parammyu));
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentAvWtogetherDataWTFileInfo.a();
  }
  
  public String toString()
  {
    Object localObject2 = null;
    StringBuilder localStringBuilder = new StringBuilder().append("PlayInfo{playState: ").append(this.jdField_a_of_type_Int).append(", playTimeMills: ").append(this.jdField_a_of_type_Long).append(", playRate: ").append(this.jdField_a_of_type_Float).append(", lastSyncTimeMills: ").append(this.b).append(", durationTimeMills: ").append(this.c).append(", fileInfo: ");
    if (this.jdField_a_of_type_ComTencentAvWtogetherDataWTFileInfo != null) {}
    for (Object localObject1 = this.jdField_a_of_type_ComTencentAvWtogetherDataWTFileInfo.toString();; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append((String)localObject1).append(", videoInfo: ");
      localObject1 = localObject2;
      if (this.jdField_a_of_type_Myu != null) {
        localObject1 = this.jdField_a_of_type_Myu.toString();
      }
      return (String)localObject1 + "}";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     myv
 * JD-Core Version:    0.7.0.1
 */