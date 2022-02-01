import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public final class gw
{
  private static final gw[] jdField_a_of_type_ArrayOfGw = ;
  private final int jdField_a_of_type_Int;
  private final gy[] jdField_a_of_type_ArrayOfGy;
  private final int b;
  
  private gw(int paramInt, int[] paramArrayOfInt, gy... paramVarArgs)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ArrayOfGy = paramVarArgs;
    int k = paramVarArgs[0].a();
    paramArrayOfInt = paramVarArgs[0].a();
    int m = paramArrayOfInt.length;
    int i = 0;
    paramInt = j;
    while (paramInt < m)
    {
      paramVarArgs = paramArrayOfInt[paramInt];
      j = paramVarArgs.a();
      i += (paramVarArgs.b() + k) * j;
      paramInt += 1;
    }
    this.b = i;
  }
  
  public static gw a(int paramInt)
  {
    if ((paramInt < 1) || (paramInt > 40)) {
      throw new IllegalArgumentException();
    }
    return jdField_a_of_type_ArrayOfGw[(paramInt - 1)];
  }
  
  private static gw[] a()
  {
    Object localObject1 = new gy(7, new gx[] { new gx(1, 19) });
    Object localObject2 = new gy(10, new gx[] { new gx(1, 16) });
    Object localObject3 = new gy(13, new gx[] { new gx(1, 13) });
    Object localObject4 = new gy(17, new gx[] { new gx(1, 9) });
    localObject1 = new gw(1, new int[0], new gy[] { localObject1, localObject2, localObject3, localObject4 });
    localObject2 = new gy(10, new gx[] { new gx(1, 34) });
    localObject3 = new gy(16, new gx[] { new gx(1, 28) });
    localObject4 = new gy(22, new gx[] { new gx(1, 22) });
    Object localObject5 = new gy(28, new gx[] { new gx(1, 16) });
    localObject2 = new gw(2, new int[] { 6, 18 }, new gy[] { localObject2, localObject3, localObject4, localObject5 });
    localObject3 = new gy(15, new gx[] { new gx(1, 55) });
    localObject4 = new gy(26, new gx[] { new gx(1, 44) });
    localObject5 = new gy(18, new gx[] { new gx(2, 17) });
    Object localObject6 = new gy(22, new gx[] { new gx(2, 13) });
    localObject3 = new gw(3, new int[] { 6, 22 }, new gy[] { localObject3, localObject4, localObject5, localObject6 });
    localObject4 = new gy(20, new gx[] { new gx(1, 80) });
    localObject5 = new gy(18, new gx[] { new gx(2, 32) });
    localObject6 = new gy(26, new gx[] { new gx(2, 24) });
    Object localObject7 = new gy(16, new gx[] { new gx(4, 9) });
    localObject4 = new gw(4, new int[] { 6, 26 }, new gy[] { localObject4, localObject5, localObject6, localObject7 });
    localObject5 = new gy(26, new gx[] { new gx(1, 108) });
    localObject6 = new gy(24, new gx[] { new gx(2, 43) });
    localObject7 = new gy(18, new gx[] { new gx(2, 15), new gx(2, 16) });
    Object localObject8 = new gy(22, new gx[] { new gx(2, 11), new gx(2, 12) });
    localObject5 = new gw(5, new int[] { 6, 30 }, new gy[] { localObject5, localObject6, localObject7, localObject8 });
    localObject6 = new gy(18, new gx[] { new gx(2, 68) });
    localObject7 = new gy(16, new gx[] { new gx(4, 27) });
    localObject8 = new gy(24, new gx[] { new gx(4, 19) });
    Object localObject9 = new gy(28, new gx[] { new gx(4, 15) });
    localObject6 = new gw(6, new int[] { 6, 34 }, new gy[] { localObject6, localObject7, localObject8, localObject9 });
    localObject7 = new gy(20, new gx[] { new gx(2, 78) });
    localObject8 = new gy(18, new gx[] { new gx(4, 31) });
    localObject9 = new gy(18, new gx[] { new gx(2, 14), new gx(4, 15) });
    Object localObject10 = new gy(26, new gx[] { new gx(4, 13), new gx(1, 14) });
    localObject7 = new gw(7, new int[] { 6, 22, 38 }, new gy[] { localObject7, localObject8, localObject9, localObject10 });
    localObject8 = new gy(24, new gx[] { new gx(2, 97) });
    localObject9 = new gy(22, new gx[] { new gx(2, 38), new gx(2, 39) });
    localObject10 = new gy(22, new gx[] { new gx(4, 18), new gx(2, 19) });
    Object localObject11 = new gy(26, new gx[] { new gx(4, 14), new gx(2, 15) });
    localObject8 = new gw(8, new int[] { 6, 24, 42 }, new gy[] { localObject8, localObject9, localObject10, localObject11 });
    localObject9 = new gy(30, new gx[] { new gx(2, 116) });
    localObject10 = new gy(22, new gx[] { new gx(3, 36), new gx(2, 37) });
    localObject11 = new gy(20, new gx[] { new gx(4, 16), new gx(4, 17) });
    Object localObject12 = new gy(24, new gx[] { new gx(4, 12), new gx(4, 13) });
    localObject9 = new gw(9, new int[] { 6, 26, 46 }, new gy[] { localObject9, localObject10, localObject11, localObject12 });
    localObject10 = new gy(18, new gx[] { new gx(2, 68), new gx(2, 69) });
    localObject11 = new gy(26, new gx[] { new gx(4, 43), new gx(1, 44) });
    localObject12 = new gy(24, new gx[] { new gx(6, 19), new gx(2, 20) });
    Object localObject13 = new gy(28, new gx[] { new gx(6, 15), new gx(2, 16) });
    localObject10 = new gw(10, new int[] { 6, 28, 50 }, new gy[] { localObject10, localObject11, localObject12, localObject13 });
    localObject11 = new gy(20, new gx[] { new gx(4, 81) });
    localObject12 = new gy(30, new gx[] { new gx(1, 50), new gx(4, 51) });
    localObject13 = new gy(28, new gx[] { new gx(4, 22), new gx(4, 23) });
    Object localObject14 = new gy(24, new gx[] { new gx(3, 12), new gx(8, 13) });
    localObject11 = new gw(11, new int[] { 6, 30, 54 }, new gy[] { localObject11, localObject12, localObject13, localObject14 });
    localObject12 = new gy(24, new gx[] { new gx(2, 92), new gx(2, 93) });
    localObject13 = new gy(22, new gx[] { new gx(6, 36), new gx(2, 37) });
    localObject14 = new gy(26, new gx[] { new gx(4, 20), new gx(6, 21) });
    Object localObject15 = new gy(28, new gx[] { new gx(7, 14), new gx(4, 15) });
    localObject12 = new gw(12, new int[] { 6, 32, 58 }, new gy[] { localObject12, localObject13, localObject14, localObject15 });
    localObject13 = new gy(26, new gx[] { new gx(4, 107) });
    localObject14 = new gy(22, new gx[] { new gx(8, 37), new gx(1, 38) });
    localObject15 = new gy(24, new gx[] { new gx(8, 20), new gx(4, 21) });
    Object localObject16 = new gy(22, new gx[] { new gx(12, 11), new gx(4, 12) });
    localObject13 = new gw(13, new int[] { 6, 34, 62 }, new gy[] { localObject13, localObject14, localObject15, localObject16 });
    localObject14 = new gy(30, new gx[] { new gx(3, 115), new gx(1, 116) });
    localObject15 = new gy(24, new gx[] { new gx(4, 40), new gx(5, 41) });
    localObject16 = new gy(20, new gx[] { new gx(11, 16), new gx(5, 17) });
    Object localObject17 = new gy(24, new gx[] { new gx(11, 12), new gx(5, 13) });
    localObject14 = new gw(14, new int[] { 6, 26, 46, 66 }, new gy[] { localObject14, localObject15, localObject16, localObject17 });
    localObject15 = new gy(22, new gx[] { new gx(5, 87), new gx(1, 88) });
    localObject16 = new gy(24, new gx[] { new gx(5, 41), new gx(5, 42) });
    localObject17 = new gy(30, new gx[] { new gx(5, 24), new gx(7, 25) });
    Object localObject18 = new gy(24, new gx[] { new gx(11, 12), new gx(7, 13) });
    localObject15 = new gw(15, new int[] { 6, 26, 48, 70 }, new gy[] { localObject15, localObject16, localObject17, localObject18 });
    localObject16 = new gy(24, new gx[] { new gx(5, 98), new gx(1, 99) });
    localObject17 = new gy(28, new gx[] { new gx(7, 45), new gx(3, 46) });
    localObject18 = new gy(24, new gx[] { new gx(15, 19), new gx(2, 20) });
    Object localObject19 = new gy(30, new gx[] { new gx(3, 15), new gx(13, 16) });
    localObject16 = new gw(16, new int[] { 6, 26, 50, 74 }, new gy[] { localObject16, localObject17, localObject18, localObject19 });
    localObject17 = new gy(28, new gx[] { new gx(1, 107), new gx(5, 108) });
    localObject18 = new gy(28, new gx[] { new gx(10, 46), new gx(1, 47) });
    localObject19 = new gy(28, new gx[] { new gx(1, 22), new gx(15, 23) });
    Object localObject20 = new gy(28, new gx[] { new gx(2, 14), new gx(17, 15) });
    localObject17 = new gw(17, new int[] { 6, 30, 54, 78 }, new gy[] { localObject17, localObject18, localObject19, localObject20 });
    localObject18 = new gy(30, new gx[] { new gx(5, 120), new gx(1, 121) });
    localObject19 = new gy(26, new gx[] { new gx(9, 43), new gx(4, 44) });
    localObject20 = new gy(28, new gx[] { new gx(17, 22), new gx(1, 23) });
    Object localObject21 = new gy(28, new gx[] { new gx(2, 14), new gx(19, 15) });
    localObject18 = new gw(18, new int[] { 6, 30, 56, 82 }, new gy[] { localObject18, localObject19, localObject20, localObject21 });
    localObject19 = new gy(28, new gx[] { new gx(3, 113), new gx(4, 114) });
    localObject20 = new gy(26, new gx[] { new gx(3, 44), new gx(11, 45) });
    localObject21 = new gy(26, new gx[] { new gx(17, 21), new gx(4, 22) });
    Object localObject22 = new gy(26, new gx[] { new gx(9, 13), new gx(16, 14) });
    localObject19 = new gw(19, new int[] { 6, 30, 58, 86 }, new gy[] { localObject19, localObject20, localObject21, localObject22 });
    localObject20 = new gy(28, new gx[] { new gx(3, 107), new gx(5, 108) });
    localObject21 = new gy(26, new gx[] { new gx(3, 41), new gx(13, 42) });
    localObject22 = new gy(30, new gx[] { new gx(15, 24), new gx(5, 25) });
    Object localObject23 = new gy(28, new gx[] { new gx(15, 15), new gx(10, 16) });
    localObject20 = new gw(20, new int[] { 6, 34, 62, 90 }, new gy[] { localObject20, localObject21, localObject22, localObject23 });
    localObject21 = new gy(28, new gx[] { new gx(4, 116), new gx(4, 117) });
    localObject22 = new gy(26, new gx[] { new gx(17, 42) });
    localObject23 = new gy(28, new gx[] { new gx(17, 22), new gx(6, 23) });
    Object localObject24 = new gy(30, new gx[] { new gx(19, 16), new gx(6, 17) });
    localObject21 = new gw(21, new int[] { 6, 28, 50, 72, 94 }, new gy[] { localObject21, localObject22, localObject23, localObject24 });
    localObject22 = new gy(28, new gx[] { new gx(2, 111), new gx(7, 112) });
    localObject23 = new gy(28, new gx[] { new gx(17, 46) });
    localObject24 = new gy(30, new gx[] { new gx(7, 24), new gx(16, 25) });
    Object localObject25 = new gy(24, new gx[] { new gx(34, 13) });
    localObject22 = new gw(22, new int[] { 6, 26, 50, 74, 98 }, new gy[] { localObject22, localObject23, localObject24, localObject25 });
    localObject23 = new gy(30, new gx[] { new gx(4, 121), new gx(5, 122) });
    localObject24 = new gy(28, new gx[] { new gx(4, 47), new gx(14, 48) });
    localObject25 = new gy(30, new gx[] { new gx(11, 24), new gx(14, 25) });
    Object localObject26 = new gy(30, new gx[] { new gx(16, 15), new gx(14, 16) });
    localObject23 = new gw(23, new int[] { 6, 30, 54, 78, 102 }, new gy[] { localObject23, localObject24, localObject25, localObject26 });
    localObject24 = new gy(30, new gx[] { new gx(6, 117), new gx(4, 118) });
    localObject25 = new gy(28, new gx[] { new gx(6, 45), new gx(14, 46) });
    localObject26 = new gy(30, new gx[] { new gx(11, 24), new gx(16, 25) });
    Object localObject27 = new gy(30, new gx[] { new gx(30, 16), new gx(2, 17) });
    localObject24 = new gw(24, new int[] { 6, 28, 54, 80, 106 }, new gy[] { localObject24, localObject25, localObject26, localObject27 });
    localObject25 = new gy(26, new gx[] { new gx(8, 106), new gx(4, 107) });
    localObject26 = new gy(28, new gx[] { new gx(8, 47), new gx(13, 48) });
    localObject27 = new gy(30, new gx[] { new gx(7, 24), new gx(22, 25) });
    Object localObject28 = new gy(30, new gx[] { new gx(22, 15), new gx(13, 16) });
    localObject25 = new gw(25, new int[] { 6, 32, 58, 84, 110 }, new gy[] { localObject25, localObject26, localObject27, localObject28 });
    localObject26 = new gy(28, new gx[] { new gx(10, 114), new gx(2, 115) });
    localObject27 = new gy(28, new gx[] { new gx(19, 46), new gx(4, 47) });
    localObject28 = new gy(28, new gx[] { new gx(28, 22), new gx(6, 23) });
    Object localObject29 = new gy(30, new gx[] { new gx(33, 16), new gx(4, 17) });
    localObject26 = new gw(26, new int[] { 6, 30, 58, 86, 114 }, new gy[] { localObject26, localObject27, localObject28, localObject29 });
    localObject27 = new gy(30, new gx[] { new gx(8, 122), new gx(4, 123) });
    localObject28 = new gy(28, new gx[] { new gx(22, 45), new gx(3, 46) });
    localObject29 = new gy(30, new gx[] { new gx(8, 23), new gx(26, 24) });
    Object localObject30 = new gy(30, new gx[] { new gx(12, 15), new gx(28, 16) });
    localObject27 = new gw(27, new int[] { 6, 34, 62, 90, 118 }, new gy[] { localObject27, localObject28, localObject29, localObject30 });
    localObject28 = new gy(30, new gx[] { new gx(3, 117), new gx(10, 118) });
    localObject29 = new gy(28, new gx[] { new gx(3, 45), new gx(23, 46) });
    localObject30 = new gy(30, new gx[] { new gx(4, 24), new gx(31, 25) });
    Object localObject31 = new gy(30, new gx[] { new gx(11, 15), new gx(31, 16) });
    localObject28 = new gw(28, new int[] { 6, 26, 50, 74, 98, 122 }, new gy[] { localObject28, localObject29, localObject30, localObject31 });
    localObject29 = new gy(30, new gx[] { new gx(7, 116), new gx(7, 117) });
    localObject30 = new gy(28, new gx[] { new gx(21, 45), new gx(7, 46) });
    localObject31 = new gy(30, new gx[] { new gx(1, 23), new gx(37, 24) });
    Object localObject32 = new gy(30, new gx[] { new gx(19, 15), new gx(26, 16) });
    localObject29 = new gw(29, new int[] { 6, 30, 54, 78, 102, 126 }, new gy[] { localObject29, localObject30, localObject31, localObject32 });
    localObject30 = new gy(30, new gx[] { new gx(5, 115), new gx(10, 116) });
    localObject31 = new gy(28, new gx[] { new gx(19, 47), new gx(10, 48) });
    localObject32 = new gy(30, new gx[] { new gx(15, 24), new gx(25, 25) });
    Object localObject33 = new gy(30, new gx[] { new gx(23, 15), new gx(25, 16) });
    localObject30 = new gw(30, new int[] { 6, 26, 52, 78, 104, 130 }, new gy[] { localObject30, localObject31, localObject32, localObject33 });
    localObject31 = new gy(30, new gx[] { new gx(13, 115), new gx(3, 116) });
    localObject32 = new gy(28, new gx[] { new gx(2, 46), new gx(29, 47) });
    localObject33 = new gy(30, new gx[] { new gx(42, 24), new gx(1, 25) });
    Object localObject34 = new gy(30, new gx[] { new gx(23, 15), new gx(28, 16) });
    localObject31 = new gw(31, new int[] { 6, 30, 56, 82, 108, 134 }, new gy[] { localObject31, localObject32, localObject33, localObject34 });
    localObject32 = new gy(30, new gx[] { new gx(17, 115) });
    localObject33 = new gy(28, new gx[] { new gx(10, 46), new gx(23, 47) });
    localObject34 = new gy(30, new gx[] { new gx(10, 24), new gx(35, 25) });
    Object localObject35 = new gy(30, new gx[] { new gx(19, 15), new gx(35, 16) });
    localObject32 = new gw(32, new int[] { 6, 34, 60, 86, 112, 138 }, new gy[] { localObject32, localObject33, localObject34, localObject35 });
    localObject33 = new gy(30, new gx[] { new gx(17, 115), new gx(1, 116) });
    localObject34 = new gy(28, new gx[] { new gx(14, 46), new gx(21, 47) });
    localObject35 = new gy(30, new gx[] { new gx(29, 24), new gx(19, 25) });
    Object localObject36 = new gy(30, new gx[] { new gx(11, 15), new gx(46, 16) });
    localObject33 = new gw(33, new int[] { 6, 30, 58, 86, 114, 142 }, new gy[] { localObject33, localObject34, localObject35, localObject36 });
    localObject34 = new gy(30, new gx[] { new gx(13, 115), new gx(6, 116) });
    localObject35 = new gy(28, new gx[] { new gx(14, 46), new gx(23, 47) });
    localObject36 = new gy(30, new gx[] { new gx(44, 24), new gx(7, 25) });
    Object localObject37 = new gy(30, new gx[] { new gx(59, 16), new gx(1, 17) });
    localObject34 = new gw(34, new int[] { 6, 34, 62, 90, 118, 146 }, new gy[] { localObject34, localObject35, localObject36, localObject37 });
    localObject35 = new gy(30, new gx[] { new gx(12, 121), new gx(7, 122) });
    localObject36 = new gy(28, new gx[] { new gx(12, 47), new gx(26, 48) });
    localObject37 = new gy(30, new gx[] { new gx(39, 24), new gx(14, 25) });
    Object localObject38 = new gy(30, new gx[] { new gx(22, 15), new gx(41, 16) });
    localObject35 = new gw(35, new int[] { 6, 30, 54, 78, 102, 126, 150 }, new gy[] { localObject35, localObject36, localObject37, localObject38 });
    localObject36 = new gy(30, new gx[] { new gx(6, 121), new gx(14, 122) });
    localObject37 = new gy(28, new gx[] { new gx(6, 47), new gx(34, 48) });
    localObject38 = new gy(30, new gx[] { new gx(46, 24), new gx(10, 25) });
    Object localObject39 = new gy(30, new gx[] { new gx(2, 15), new gx(64, 16) });
    localObject36 = new gw(36, new int[] { 6, 24, 50, 76, 102, 128, 154 }, new gy[] { localObject36, localObject37, localObject38, localObject39 });
    localObject37 = new gy(30, new gx[] { new gx(17, 122), new gx(4, 123) });
    localObject38 = new gy(28, new gx[] { new gx(29, 46), new gx(14, 47) });
    localObject39 = new gy(30, new gx[] { new gx(49, 24), new gx(10, 25) });
    gy localgy1 = new gy(30, new gx[] { new gx(24, 15), new gx(46, 16) });
    localObject37 = new gw(37, new int[] { 6, 28, 54, 80, 106, 132, 158 }, new gy[] { localObject37, localObject38, localObject39, localgy1 });
    localObject38 = new gy(30, new gx[] { new gx(4, 122), new gx(18, 123) });
    localObject39 = new gy(28, new gx[] { new gx(13, 46), new gx(32, 47) });
    localgy1 = new gy(30, new gx[] { new gx(48, 24), new gx(14, 25) });
    gy localgy2 = new gy(30, new gx[] { new gx(42, 15), new gx(32, 16) });
    localObject38 = new gw(38, new int[] { 6, 32, 58, 84, 110, 136, 162 }, new gy[] { localObject38, localObject39, localgy1, localgy2 });
    localObject39 = new gy(30, new gx[] { new gx(20, 117), new gx(4, 118) });
    localgy1 = new gy(28, new gx[] { new gx(40, 47), new gx(7, 48) });
    localgy2 = new gy(30, new gx[] { new gx(43, 24), new gx(22, 25) });
    gy localgy3 = new gy(30, new gx[] { new gx(10, 15), new gx(67, 16) });
    localObject39 = new gw(39, new int[] { 6, 26, 54, 82, 110, 138, 166 }, new gy[] { localObject39, localgy1, localgy2, localgy3 });
    localgy1 = new gy(30, new gx[] { new gx(19, 118), new gx(6, 119) });
    localgy2 = new gy(28, new gx[] { new gx(18, 47), new gx(31, 48) });
    localgy3 = new gy(30, new gx[] { new gx(34, 24), new gx(34, 25) });
    gy localgy4 = new gy(30, new gx[] { new gx(20, 15), new gx(61, 16) });
    return new gw[] { localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localObject7, localObject8, localObject9, localObject10, localObject11, localObject12, localObject13, localObject14, localObject15, localObject16, localObject17, localObject18, localObject19, localObject20, localObject21, localObject22, localObject23, localObject24, localObject25, localObject26, localObject27, localObject28, localObject29, localObject30, localObject31, localObject32, localObject33, localObject34, localObject35, localObject36, localObject37, localObject38, localObject39, new gw(40, new int[] { 6, 30, 58, 86, 114, 142, 170 }, new gy[] { localgy1, localgy2, localgy3, localgy4 }) };
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public gy a(ErrorCorrectionLevel paramErrorCorrectionLevel)
  {
    return this.jdField_a_of_type_ArrayOfGy[paramErrorCorrectionLevel.ordinal()];
  }
  
  public int b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int * 4 + 17;
  }
  
  public String toString()
  {
    return String.valueOf(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     gw
 * JD-Core Version:    0.7.0.1
 */