package com.tencent.pb.apolloactionused;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class ApolloActionUsed$EmuTopo
  extends MessageMicro<EmuTopo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "emus", "pkgid" }, new Object[] { null, Integer.valueOf(0) }, EmuTopo.class);
  public final PBRepeatMessageField<ApolloActionUsed.EmuInfo> emus = PBField.initRepeatMessage(ApolloActionUsed.EmuInfo.class);
  public final PBInt32Field pkgid = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.apolloactionused.ApolloActionUsed.EmuTopo
 * JD-Core Version:    0.7.0.1
 */