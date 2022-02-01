package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class GetUserAddFriendSettingResp
  extends JceStruct
{
  static byte[] cache_name;
  static byte[] cache_name1;
  static int cache_queryuinsetting;
  static int cache_result;
  static ArrayList<String> cache_vecStrUserQuestion;
  public boolean contact_bothway_friend = false;
  public short errorCode = 0;
  public byte[] name = null;
  public byte[] name1 = null;
  public long queryuin = 0L;
  public int queryuinsetting = 0;
  public int result = 0;
  public long uin = 0L;
  public ArrayList<String> vecStrUserQuestion = null;
  
  public GetUserAddFriendSettingResp() {}
  
  public GetUserAddFriendSettingResp(long paramLong1, long paramLong2, int paramInt1, ArrayList<String> paramArrayList, int paramInt2, short paramShort, byte[] paramArrayOfByte1, boolean paramBoolean, byte[] paramArrayOfByte2)
  {
    this.uin = paramLong1;
    this.queryuin = paramLong2;
    this.queryuinsetting = paramInt1;
    this.vecStrUserQuestion = paramArrayList;
    this.result = paramInt2;
    this.errorCode = paramShort;
    this.name = paramArrayOfByte1;
    this.contact_bothway_friend = paramBoolean;
    this.name1 = paramArrayOfByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.queryuin = paramJceInputStream.read(this.queryuin, 1, true);
    this.queryuinsetting = paramJceInputStream.read(this.queryuinsetting, 2, true);
    if (cache_vecStrUserQuestion == null)
    {
      cache_vecStrUserQuestion = new ArrayList();
      cache_vecStrUserQuestion.add("");
    }
    this.vecStrUserQuestion = ((ArrayList)paramJceInputStream.read(cache_vecStrUserQuestion, 3, false));
    this.result = paramJceInputStream.read(this.result, 4, true);
    this.errorCode = paramJceInputStream.read(this.errorCode, 5, false);
    if (cache_name == null)
    {
      cache_name = (byte[])new byte[1];
      ((byte[])cache_name)[0] = 0;
    }
    this.name = ((byte[])paramJceInputStream.read(cache_name, 6, false));
    this.contact_bothway_friend = paramJceInputStream.read(this.contact_bothway_friend, 7, false);
    if (cache_name1 == null)
    {
      cache_name1 = (byte[])new byte[1];
      ((byte[])cache_name1)[0] = 0;
    }
    this.name1 = ((byte[])paramJceInputStream.read(cache_name1, 8, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.queryuin, 1);
    paramJceOutputStream.write(this.queryuinsetting, 2);
    Object localObject = this.vecStrUserQuestion;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 3);
    }
    paramJceOutputStream.write(this.result, 4);
    paramJceOutputStream.write(this.errorCode, 5);
    localObject = this.name;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 6);
    }
    paramJceOutputStream.write(this.contact_bothway_friend, 7);
    localObject = this.name1;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     friendlist.GetUserAddFriendSettingResp
 * JD-Core Version:    0.7.0.1
 */