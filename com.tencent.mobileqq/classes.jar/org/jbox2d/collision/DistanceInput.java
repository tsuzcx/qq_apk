package org.jbox2d.collision;

import org.jbox2d.common.Transform;

public class DistanceInput
{
  public Distance.DistanceProxy proxyA = new Distance.DistanceProxy();
  public Distance.DistanceProxy proxyB = new Distance.DistanceProxy();
  public Transform transformA = new Transform();
  public Transform transformB = new Transform();
  public boolean useRadii;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.collision.DistanceInput
 * JD-Core Version:    0.7.0.1
 */